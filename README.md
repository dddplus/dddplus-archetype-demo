# dddplus-archetype-demo
Using [dddplus-archetype](https://github.com/dddplus/dddplus-archetype) build a WMS. 利用 [dddplus-archetype](https://github.com/dddplus/dddplus-archetype) 5分钟搭建一个仓储系统WMS！

## 演示简介

仓储系统，WMS(warehouse managment system)，在整个供应链中起着至关重要的作用，它主要由四大部分组成：
- 入库管理
- 在库管理
- 出库管理
- 基础数据

本演示目标：
- 快速搭建一个WMS的入库(inbound，简称ib)中台骨架
- 完成一个不算简单的use case：创建上架任务

## 第一分钟：利用dddplus-archtype创建项目

``` bash
mvn archetype:generate -DarchetypeGroupId=io.github.dddplus -DarchetypeArtifactId=dddplus-archetype -DarchetypeVersion=1.0.2-SNAPSHOT -DgroupId=io.wms -DartifactId=wms-ib -Dpackage=io.wms.ib -Dversion=1.0.0-SNAPSHOT -DinteractiveMode=false
```

[github上查看该项工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/7e150d0...minute-1).

该过程，不需要开发代码，完全自动生成。

## 第二分钟：实现`创建上架任务`用例的骨架

### 业务介绍

创建上架任务，是指采购的货品已送达仓库，完成了扫码、验收，现在要存放到库房的货架上。

具体地，仓库工人会对货品进行验收，利用手持设备扫描每个商品条码，都完成后点击`验收完毕`按钮，服务器会调用`创建上架任务`API。

本演示就是要完成该API。

`上架`，这里使用英文`shelving`。

### 开发内容

- wms-ib-api 模块，定义对外暴露的API
- wms-ib-facade 模块，实现该API
- wms-ib-application 模块，编排领域服务，在 use case 层实现该API
- wms-ib-domain 模块，实现核心业务逻辑
   - 定义领域模型、领域服务
   - wms-ib-spec 模块，定义领域模型规范
   - 通过依赖倒置定义基础设施层需要实现的技术细节接口
- wms-ib-infrastructure 模块，实现领域层要求的技术细节接口
   - 定义物理模型
- wms-ib-test 模块，单元测试模块，主要针对domain层编写测试用例

[github上查看该项工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/minute-1...minute-2).

## 后三分钟：完成`创建上架任务`业务逻辑

### 业务梳理和抽象

需要领域专家和研发同学共同参与完成。

`创建上架任务`从业务上被抽象成如下步骤来完成：
- 防重校验
- 通过RPC调用`人工智能系统：推荐储位`服务
   - 一个sku，可能推荐到多个储位
   - 因此需要根据数量拆分
- 库存查询商品保质期
- 落库保存，等待后续的任务分配

### 多场景下业务多态

### 开发内容

- wms-ib-domain 模块
   - 定义领域步骤
- wms-ib-infrastructure 模块，实现所有相关
   - 包括事务
   - 此处省略了 cache/DAO/MQ/RPC dubbo 等实现

[github上查看该项工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/minute-2...minute-3).

## 后续

- 根据业务的多态性，针对更多的业务场景，定义扩展点
- 根据业务复杂度和自治性，抽象出多个支撑域
- 根据组织上的前中台架构，和业务特征，定义 Partner 和 Pattern，并绑定扩展点实现
