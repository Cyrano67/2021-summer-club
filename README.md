# 2021-summer-club

### 仓库克隆
大伙克隆仓库前，用两个命令设置一下github的用户名和邮箱
- `git config --global user.name "youname"`
- `git config --global user.email "aa@qq.com"`
然后再克隆仓库
  
### zookeeper注册中心
- 现在有两组zookeeper和dubbo，如果有服务上的冲突，可以选用另外一组进行测试
- 修改各个服务的`application.yml`中的zookeeper，记得要全部修改哦
1. zookeeper: `116.63.139.22:10000`, dubbo-admin: `116.63.139.22:11000`
2. zookeeper: `122.9.144.83:2181`, dubbo-admin: `116.63.139.22:20880`
