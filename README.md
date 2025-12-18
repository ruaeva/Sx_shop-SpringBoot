# Shop 电商系统

一个基于 Spring Boot 和 MyBatis-Plus 的电商系统后端 API。

## 技术栈

- Spring Boot 3.5.8
- MyBatis-Plus 3.5.15
- MySQL 数据库
- Maven 项目管理
- H2 内存数据库（测试环境）

## 功能特性

- 商品管理（增删改查）
- 分页查询
- 商品上下架功能
- 跨域支持（CORS）
- RESTful API 设计

## API 接口

### 商品管理

- `GET /shop/api/product` - 获取上架商品列表（分页）
- `GET /shop/api/product/all` - 获取所有商品列表（分页）
- `GET /shop/api/product/{id}` - 获取特定商品详情
- `POST /shop/api/product` - 创建新商品
- `PUT /shop/api/product/{id}` - 更新特定商品
- `PUT /shop/api/product/{id}/on-sale` - 上架商品
- `PUT /shop/api/product/{id}/off-sale` - 下架商品
- `DELETE /shop/api/product/{id}` - 删除特定商品
- `DELETE /shop/api/product` - 批量删除商品

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/example/shop/
│   │       ├── ShopApplication.java
│   │       ├── controller/
│   │       │   └── ProductController.java
│   │       ├── entity/
│   │       │   └── Product.java
│   │       ├── mapper/
│   │       │   └── ProductMapper.java
│   │       ├── service/
│   │       │   └── ProductService.java
│   │       └── config/
│   │           └── CorsConfig.java
│   └── resources/
│       ├── application.properties
│       ├── mapper/
│       ├── static/
│       └── templates/
└── test/
    └── java/
        └── com/example/shop/
            └── ShopApplicationTests.java
```

## 环境配置

### 数据库配置

项目使用 MySQL 数据库，配置在 `application.properties` 文件中：

```properties
spring.datasource.url=<your-database-url>
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
```

测试环境使用 H2 内存数据库：

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

### 服务器配置

- 端口：8888
- 上下文路径：/shop

## 快速开始

1. 克隆项目
```bash
git clone https://github.com/ruaeva/Sx_shop-SpringBoot.git
```

2. 配置数据库连接信息

3. 编译并运行
```bash
mvn spring-boot:run
```

4. 访问 API 接口 `http://localhost:8888/shop/api/product`

## 跨域配置

项目已配置跨域资源共享（CORS），允许前端应用访问后端 API。

## 数据库表结构

产品表（product）：
- id: 主键
- name: 商品名称
- desc: 商品描述
- price: 价格
- sales: 销量
- status: 商品状态（1-上架，0-下架）
- create_time: 创建时间