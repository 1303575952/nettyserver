# nettyserver
用于接收USR-G780的十六进制数据，处理并入库

当前数据入库使用JDBC裸写

添加CRC32校验
现有问题：
1.服务端ctx.write()，客户端不能收到；
2.客户端以char类型发数据到服务端，服务端以ByteBuf读，再转byte，而byte最大仅支持0x3f。