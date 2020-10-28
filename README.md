# dddplus-archetype-demo
Using [dddplus-archetype](https://github.com/dddplus/dddplus-archetype) build a WMS. 利用[dddplus-archetype](https://github.com/dddplus/dddplus-archetype)5分钟搭建一个仓储系统WMS！

## 演示简介

仓储系统，WMS(warehouse managment system)，在整个供应链中起着至关重要的作用，它主要由四大部分组成：
- 入库管理
- 在库管理
- 出库管理
- 基础数据

本演示目标：
- 快速搭建一个WMS的入库(inbound，简称ib)中台骨架
- 完成一个use case：创建上架任务

## 第一分钟：利用dddplus-archtype创建项目

``` bash
mvn archetype:generate -DarchetypeGroupId=io.github.dddplus -DarchetypeArtifactId=dddplus-archetype -DarchetypeVersion=1.0.2-SNAPSHOT -DgroupId=io.wms -DartifactId=wms-ib -Dpackage=io.wms.ib -Dversion=1.0.0-SNAPSHOT -DinteractiveMode=false
```

[github上查看本次工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/7e150d0...minute-1).

## 第二分钟：实现`创建上架任务`用例的骨架

[github上查看本次工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/minute-1...minute-2).

### 业务介绍

**创建上架任务**，是指货物已送达仓库，完成了扫码、验收，现在要存放到库房的储区货架上。

`上架`，这里使用英文`shelving`。

### 骨架内容

见[wms-ib的分层设计](wms-ib/README.md)，自上而下开始写代码。

## 后三分钟：完成`创建上架任务`业务逻辑

[github上查看本次工作成果](https://github.com/dddplus/dddplus-archetype-demo/compare/minute-2...minute-3).

### 业务抽象

需要领域专家和研发同学共同参与完成。

`创建上架任务`从业务上被抽象成如下步骤来完成：
- 基本数据校验
- 通过RPC调用`人工智能系统：推荐储位`服务
   - 一个sku，可能推荐到多个储位
   - 因此需要根据数量拆分
- 库存查询商品保质期
