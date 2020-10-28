# wms-ib

DDDplus Layered Architecture

```
wms-ib-api 系统对外暴露服务的声明
      |
wms-ib-facade 系统对外暴露服务的实现
      |
wms-ib-application UseCase层
      |
    +-------------------+
    |                   |
wms-ib-domain <-- wms-ib-infrastructure
    |
wms-ib-spec
```
