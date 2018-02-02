##springboot demo项目说明
---

本项目是基于SpringBoot + goudai + mybatis的一个demo项目。

---
####运行说明：

1.修改application.yml中数据库连接的配置(默认为127.0.0.1:3306)

2.运行doc/sql/init.sql文件创建数据库springbootdemo

3.运行SpringbootDemoApplication中main方法即可以启动应用，
启动后可以通过: http://localhost:8192/swagger-ui.html访问swagger

PS:
1.goudai工具类在test目录下的GdGenerator，可以根据实体方便地创建表并生成相关的mapper，dao等。
2.goudai请参考: https://github.com/haoa193/gd-generator


