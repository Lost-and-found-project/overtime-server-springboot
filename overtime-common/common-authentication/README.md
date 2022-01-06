# 鉴权统一标准模块

此模块为拥有**鉴权**、**颁发token**等能力的服务模块提供统一的api标准。

鉴权认证模块中也涉及到 用户-角色-权限-路由四级联动的标准接口。


请求：

响应：
200成功：

```json
{
  "token": "xxxx",
  "expireTime": 123123,
  "user": {
    "id": 123123123,
    "username": "ForteScarlet",
    "status": 0,
    "settings": {
      "aa1": "bb1",
      "aa2": "bb2"
    }
  }
}

```

失败：300+
```json
{
  "code": 112233,
  "message": "ERROR",
  "data": {  }
}
```

