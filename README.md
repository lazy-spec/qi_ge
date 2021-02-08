# 项目

本项目采用Spring框架作为基础，利用Mybatis操作数据库，Spring MVC来解耦model层和视图层，MySQL关系型数据库作为数据存储，后台使用layui编写。

## 登录

项目分为管理员和普通用户。

管理员拥有所有的权限，普通用户只拥有部分权限。

所有人员必须登录后才能访问后台资源，当直接根据请求访问后台资源时会重定向到登录页。

登录请求页面接口：

```
GET /login
```

登录逻辑处理接口：

```
POST /employee/login
```

登录成功后，跳转到主页面，登录失败不进行跳转并且提示信息。

主页页接口：

```
GET /
```

## 员工

员工页接口

```
GET /employee/index
```

员工编辑/添加页接口

```
GET /employee/add
```

## 部门

部门页接口

```
GET /dept/index
```

部门编辑/添加页接口

```
GET /dept/add
```

## 职位

职位页接口

```
GET /position/index
```

职位编辑/添加页接口

```
GET /position/add
```

## 考勤

考勤页接口

```
GET /attendance/index
```

考勤页编辑/添加接口

```
GET /attendance
```

## 下载中心

下载中心页接口

```
GET /downloadcenter/index
```

上传文件页接口

```
GET /downloadcenter/add
```

上传文件的路径为项目路径下的upload目录，如果需要修改，请Const类下的path_url，也可以联系我。