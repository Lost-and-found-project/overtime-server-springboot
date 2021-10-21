# Overtime-server-springboot

基于Springboot的 `overtime` 服务端.

## 相关内容：
- Gradle with Kotlin DSL build script
- Java17
- Spring Reactive (webflux)
- Spring Data R2DBC
- 使用Nacos的配置中心与服务注册发现
- Lombok


## 基本结构：
- `overtime-application`: 所有服务的单机模块。
- `overtime-common`: 公共模块的父模块。
  - `overtime-core`: 没有特别所属，供全局使用的公共模块，一般提供一些工具类、响应数据封装等内容。
  - `overtime-controller`: 为Controller模块服务的公共模块，其中提供了针对于启动器Application的配置工具等内容。
  - `overtime-domain`: 为domain模块服务的公共模块。
  - `overtime-service`: 为service模块服务的公共模块。
- `overtime-configuration`: 与配置相关的父模块。
  - `configuration-handler`: 针对响应值统一处理、异常统一拦截的配置模块。
- `overtime-gateway`: 网关模块。
- `services`: 所有的服务模块。
  - `${service-name}`: 某服务的父模块。
    - `${service-name}-domain`: 提供domain定义的模块。
    - `${service-name}-repository`: 提供持久层交互的模块。
    - `${service-name}-service`: 服务**接口**定义模块
    - `${service-name}-service-impl`: 服务接口的默认**实现**模块。此模块实现 `${service-name}-service` 模块接口。
    - `${service-name}-api`: 服务间**API**的接口定义模块。
    - `${service-name}-controller`: 对外http控制器模块，此模块实现 `${service-name}-api` 模块接口。

