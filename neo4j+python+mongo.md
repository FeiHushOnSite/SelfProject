##### Mongo:

Mongo服务启动(根文件下bin目录) service start(under root \bin):

```shell
mongod --dbpath D:\MongoDB\data
2019-06-18T19:52:11.181-0700 I CONTROL  [initandlisten]
2019-06-19T10:52:11.183+0800 I STORAGE  [initandlisten] createCollection: admin.system.version with provided UUID: f45adaf5-2a76-46f0-8d24-ca53fcc2cc34
2019-06-19T10:52:11.201+0800 I COMMAND  [initandlisten] setting featureCompatibilityVersion to 4.0
2019-06-19T10:52:11.210+0800 I STORAGE  [initandlisten] createCollection: local.startup_log with generated UUID: 10946dd6-4db3-42d2-9f1c-96efe85c43be
2019-06-19T10:52:11.777+0800 I FTDC     [initandlisten] Initializing full-time diagnostic data capture with directory 'D:/MongoDB/data/diagnostic.data'
2019-06-19T10:52:11.782+0800 I NETWORK  [initandlisten] waiting for connections on port 27017
```

------------------------------------------------------------------------------------------------------------------------------------------------

```shell
mongod --port 27017 --dbpath ./data --logpath ./log/mongod.log -logappend

db  #查看当前哪个数据库 (check database)
use db_name #数据库是虚拟的  所以use的时候不管db是不是存在,只有在有数据的时候才会创建
show collections #查看数据库中有那些集合 

CRUD
db.collection_name.insert({one:'1',two:'2'}) #一个集合中的数据的结构是可以不一样的
db.collection_name.find({这里加要找的参数}) #发挥的是找到的集合内有什么
db.collection_name.remove({查找条件})
db.collection_name.update({查找到的条件},{更改或插入的参数})
#这样,全部用后面的更改参数覆盖
db.collection_name.update({查找条件},{$set : {这种不是覆盖条件}})

db.collection_name.drop() #删除所有的元素

mongod.exe --logpath D:\mongodb\logs\mongodb.log --logappend --dbpath D:\mongodb\data --directoryperdb --serviceName MongoDB --install
```



-------------------------------------------------------------------------------------------------------------------------------------------------

##### NEO4J:

neo4j启动服务 (start service):

neo4j.bat console               -------->>>密码:jifeiyu

安装和卸载服务 (install and uninstall service commond):

bin\neo4j install-service

cypher 语法 (syntax): -----------(Node语法) (syntax)

一，Node语法(syntax)
在cypher里面通过用一对小括号()表示一个节点，它在cypher里面查询形式如下：

1，() 代表匹配任意一个节点   stand for match any point

2, (node1) 代表匹配任意一个节点，并给它起了一个别名 match any point and give it neck name

3, (:Lable) 代表查询一个类型的数据 stand for a same type data

4, (person:Lable) 代表查询一个类型的数据，并给它起了一个别名

5, (person:Lable {name:"小王"}) 查询某个类型下，节点属性满足某个值的数据

6, (person:Lable {name:"小王",age:23})　节点的属性可以同时存在多个，是一个AND的关系

二，关系语法
关系用一对-组成，关系分有方向的进和出，如果是无方向就是进和出都查询

1,--> 指向一个节点  point

2,-[role]-> 给关系加个别名   set nick name

3,-[:acted_in]-> 访问某一类关系  

4,-[role:acted_in]-> 访问某一类关系，并加了别名

5,-[role:acted_in {roles:["neo","hadoop"]}]->

访问某一类关系下的某个属性的关系的数据

三，模式语法
模式语法是节点和关系查询语法的结合，通过模式语法我们可以进行我们想要的任意复杂的查询

(p1: Person:Actor {name:"tom"})-[role:acted_in {roles:["neo","actor"]}]-(m1:Movie {title:"water"})
四, 模式变量
为了增加模块化和减少重复，cypher允许把模式的结果指定在一个变量或者别名中，方便后续使用或操作

path = (: Person)-[:ACTED_IN]->(:Movie)

path是结果集的抽象封装，有多个函数可以直接从path里面提取数据如：

nodes(path)：提取所有的节点

rels(path): 提取所有的关系 和relationships(path)相等

length(path): 获取路径长度

五，条件
cypher语句也是由多个关键词组成，像SQL的

select name, count(*) from talbe where age=24 group by name having count(*) >2  order by count(*) desc
多个关键字组成的语法，cypher也非常类似，每个关键词会执行一个特定的task来处理数据

match: 查询的主要关键词

create: 类似sql里面的insert

filter，project，sort，page等都有对应的功能语句

```cypher
create (n:person{name:'Luxe',title:'Developer'}) return n
```

##### Anaconda:

查询版本: conda info

安装其他版本的命令: conda create --name python36 python3.6

切换其他版本的命令为: activate python36

恢复默认版本命令: deactivate

删除已有环境:conda remove --name python34 --all 

----------------------------------------------------------------------------------------------------------------------------------------------

##### Python操作Mongo:

```python
client = MongoClient('mongodb://localhost:27017/') 
db = client.test #指定数据库
collection = db.students  #指定集合
student = {  
    'id': '20170101',  
    'name': 'Jordan',  
    'age': 20,  
    'gender': 'male'  
} 
result = collection.insert_one(student)  
print(result) 
```

Demo:

```shell
> use runoobdb
switched to db runoobdb
> db.sites.find()
> db
runoobdb
> show dbs
admin   0.000GB
config  0.000GB
local   0.000GB
> db.col.insert(document)
2019-06-19T11:20:07.399+0800 E QUERY    [js] ReferenceError: document is not defined :
@(shell):1:1
> db.col.insert({title:'MongoDB 教程',description:'MongoDB 是一个Nosql 数据库',by:'菜鸟',url:'http://www.runoob.com',tags:['mongodb','database','Nosql'],likes:100})
WriteResult({ "nInserted" : 1 })
> db.col.find()
{ "_id" : ObjectId("5d09aa77856ace9d1642a595"), "title" : "MongoDB 教程", "description" : "MongoDB 是一个Nosql 数据库", "by" : "菜鸟", "url" : "http://www.runoob.com", "tags" : [ "mongodb", "database", "Nosql" ], "likes" : 100 }
> document=({title:'MongoDB 教程',description:'MongoDB 是一个Nosql 数据库',by:'菜鸟',url:'http://www.runoob.com',tags:['mongodb','database','Nosql'],likes:100})))))
{
        "title" : "MongoDB 教程",
        "description" : "MongoDB 是一个Nosql 数据库",
        "by" : "菜鸟",
        "url" : "http://www.runoob.com",
        "tags" : [
                "mongodb",
                "database",
                "Nosql"
        ],
        "likes" : 100
}
```

在python中运行:

```python
#1/usr/bin/python3

import pymongo

myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["runoobdb"]
mycol = mydb["col"]

x = mycol.find_one()

print(x)

result:
{'_id': ObjectId('5d09aa77856ace9d1642a595'), 'title': 'MongoDB 教程', 'description': 'MongoDB 是一个Nosql 数据库', 'by': '菜鸟', 'url': 'http://www.runoob.com', 'tags': ['mongodb', 'database', 'Nosql'], 'likes': 100.0}

```

