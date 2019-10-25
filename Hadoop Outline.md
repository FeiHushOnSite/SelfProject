# Hadoop Outline：

Hadoop的框架最核心的设计就是：HDFS和MapReduce。HDFS为海量的数据提供了存储，而MapReduce则为海量的数据提供了计算。 Hadoop是一个能够对大量数据进行[分布式处理](https://baike.baidu.com/item/%E5%88%86%E5%B8%83%E5%BC%8F%E5%A4%84%E7%90%86)的[软件](https://baike.baidu.com/item/%E8%BD%AF%E4%BB%B6)框架。 

Hadoop提供了

1.可靠的共享存储（分布式存储） 2.抽象的分析接口（分布式分析）

### 特性

- **大量性(volume):** 一般在大数据里，单个文件的级别至少为几十，几百GB以上
- **快速性(velocity):** 反映在数据的快速产生及数据变更的频率上
- **多样性(variety):** 泛指数据类型及其来源的多样化，进一步可以把数据结构归纳为结构化(structured)，半结构化(semi-structured)，和非结构化(unstructured)
- **易变性:** 伴随数据快速性的特征，数据流还呈现一种波动的特征。不稳定的数据流会随着日，季节，特定事件的触发出现周期性峰值
- **准确性:** 又称为数据保证(data assurance)。不同方式，渠道收集到的数据在质量上会有很大差异。数据分析和输出结果的错误程度和可信度在很大程度上取决于收集到的数据质量的高低
- **复杂性:** 体现在数据的管理和操作上。如何抽取，转换，加载，连接，关联以把握数据内蕴的有用信息已经变得越来越有挑战性

### 关键技术

1.数据分布在多台机器

可靠性：每个数据块都复制到多个节点

性能：多个节点同时处理数据

2.计算随数据走

网络IO速度 << 本地磁盘IO速度，大数据系统会尽量地将任务分配到离数据最近的机器上运行（程序运行时，将程序及其依赖包都复制到数据所在的机器运行）

代码向数据迁移，避免大规模数据时，造成大量数据迁移的情况，尽量让一段数据的计算发生在同一台机器上

3.串行IO取代随机IO

传输时间 << 寻道时间，一般数据写入后不再修改

- **HDFS:** 分布式文件存储
- **YARN:** 分布式资源管理
- **MapReduce:** 分布式计算
- **Others:** 利用YARN的资源管理功能实现其他的数据处理方式

hadoop的集群是基于master/slave模式，namenode和jobtracker属于master，datanode和tasktracker属于slave，master只有一个，而slave有多个  SecondaryNameNode内存需求和NameNode在一个数量级上，所以通常secondary NameNode（运行在单独的物理机器上）和NameNode运行在不同的机器上。 JobTracker和TaskTracker JobTracker  对应于 NameNode TaskTracker 对应于 DataNode DataNode 和NameNode 是针对数据存放来而言的 JobTracker和TaskTracker是对于MapReduce执行而言的  

### HDFS:

Hadoop Distributed File System，分布式文件系统 

HDFS负责大数据的储存，通过将大文件分块后进行分布式存储方式，突破了服务器硬盘的大小的限制，解决了单台机器无法存储大文件的问题，HDFS是个相对独立的模块，可以为YARN提供服务，也可以为HBase等其他模块提供服务。

### YARN模块：

YARN是一个通用的资源协同和任务调度框架，是为了解决Hadoop1.X中MapReduce里NameNode负载太大和其他问题而创建的一个框架。YARN是个通用框架，不止可以运行MapReduce,还可以运行Spark,Storm等其他计算框架。

MapReduce模块：

MapReduce是一个计算框架，它给出了一种数据处理方式，即通过Map阶段、Reduce阶段来分布式地流处理数据。它只适用于大数据的离线处理，对实时性要求很高的应用不适用。

jobclient，JobTracker与TaskTracker。 

1、JobClient会在用户端通过JobClient类将应用已经配置参数打包成jar文件存储到hdfs， 并把路径提交到Jobtracker,然后由JobTracker创建每一个Task（即MapTask和ReduceTask） 并将它们分发到各个TaskTracker服务中去执行 

2、JobTracker是一个master服务，软件启动之后JobTracker接收Job，负责调度Job的每一个子任务task运行于TaskTracker上， 并监控它们，如果发现有失败的task就重新运行它。一般情况应该把JobTracker部署在单独的机器上。 

3、TaskTracker是运行在多个节点上的slaver服务。TaskTracker主动与JobTracker通信，接收作业，并负责直接执行每一个任务。 TaskTracker都需要运行在HDFS的DataNode上 

- #### **Block数据块;**

  1. 基本存储单位，一般大小为64M（配置大的块主要是因为：1）减少搜寻时间，一般硬盘传输速率比寻道时间要快，大的块可以减少寻道时间；2）减少管理块的数据开销，每个块都需要在NameNode上有对应的记录；3）对数据块进行读写，减少建立网络的连接成本）
  2. 一个大文件会被拆分成一个个的块，然后存储于不同的机器。如果一个文件少于Block大小，那么实际占用的空间为其文件的大小
  3. 基本的读写单位，类似于磁盘的页，每次都是读写一个块
  4. 每个块都会被复制到多台机器，默认复制3份

- #### **NameNode**

  1. 存储文件的metadata，运行时所有数据都保存到内存，整个HDFS可存储的文件数受限于NameNode的内存大小
  2. 一个Block在NameNode中对应一条记录（一般一个block占用150字节），如果是大量的小文件，会消耗大量内存。同时map task的数量是由splits来决定的，所以用MapReduce处理大量的小文件时，就会产生过多的map task，线程管理开销将会增加作业时间。处理大量小文件的速度远远小于处理同等大小的大文件的速度。因此Hadoop建议存储大文件
  3. 数据会定时保存到本地磁盘，但不保存block的位置信息，而是由DataNode注册时上报和运行时维护（NameNode中与DataNode相关的信息并不保存到NameNode的文件系统中，而是NameNode每次重启后，动态重建）
  4. NameNode失效则整个HDFS都失效了，所以要保证NameNode的可用性

- #### **Secondary NameNode**

  1. 定时与NameNode进行同步（定期合并文件系统镜像和编辑日志，然后把合并后的传给NameNode，替换其镜像，并清空编辑日志，类似于CheckPoint机制），但NameNode失效后仍需要手工将其设置成主机

- #### **DataNode**

  1. 保存具体的block数据
  2. 负责数据的读写操作和复制操作
  3. DataNode启动时会向NameNode报告当前存储的数据块信息，后续也会定时报告修改信息
  4. DataNode之间会进行通信，复制数据块，保证数据的冗余性

###  HDFS - 命令工具:

fsck: 检查文件的完整性

start-balancer.sh: 重新平衡HDFS

hdfs dfs -copyFromLocal 从本地磁盘复制文&#x#x4EF6;到HDFS

 					**ls <path>**

 					列出路径指定的目录中的内容，示出了名称，权限，拥有者，大小和修改日期的每个条目。

 					**lsr <path>**

 					行为类似于-ls，但递归显示路径的所有子目录项。

 					**du <path>**

 					显示磁盘使用率，以字节为单位，对所有的文件，这些文件匹配的路径;文件名报告使用完整HDFS协议前缀。

 					**dus <path>**

 					类似-du，但打印路径中的所有文件/目录的磁盘使用情况的摘要。

 					**mv <src><dest>**

 					通过移动表示src到dest，在HDFS的文件或目录。

 					**cp <src> <dest>**

 					在HDFS复制确定src中的文件或目录到dest。

 					**rm <path>**

 					删除文件或路径标识的空目录。

 					**rmr <path>**

 					删除路径标识的文件或目录。递归删除所有子条目（例如，文件或路径的子目录）。

 					**put <localSrc> <dest>**

 					从本地localSrc文件系统中的DFS标识文件或目录内复制到dest。

 					**copyFromLocal <localSrc> <dest>**

 					等同于-put

 					**moveFromLocal <localSrc> <dest>**

 					从标识 localSrc本地文件系统中的文件或目录中HDFS复制到dest，然后删除本地副本上成功。

 					**get [-crc] <src> <localDest>**

 					拷贝标识 src 来确定localDest本地文件系统路径HDFS文件或目录。

 					**getmerge <src> <localDest>**

 					检索匹配的路径的src HDFS中的所有文件，并将它们复制合并文件到标识localDest本地文件系统中。

 					**cat <filen-ame>**

 					显示在标准输出文件名的内容。

 					**copyToLocal <src> <localDest>**

 					等同于 -get

 					**moveToLocal <src> <localDest>**

 					工作方式类似于-get，但删除HDFS复制成功。

 					**mkdir <path>**

 					在创建一个HDFS命名的目录路径。

 					创建任何父目录的路径丢失（例如，命令mkdir-p在Linux中）。

 					**setrep [-R] [-w] rep <path>**

 					设置标识路径代表文件的目标文件复制因子。 （实际的复制因子会向着随着时间的推移目标移动）

 					**touchz <path>**

 					创建在路径包含当前时间作为时间戳的文件。失败如果文件已经存在于路径，除非文件已经大小为0。

 					**test -[ezd] <path>**

 					返回1，如果路径存在;长度为零;或者是一个目录，否则为0。

 					**stat [format] <path>**

 					打印有关的路径信息。格式是接受块文件大小（％b），文件名（％n），块大小（%o），复制（％r）和修改日期（％y，％Y）的字符串。

 					**tail [-f] <file2name>**

 					显示在标准输出文件的最后1KB。

 					**chmod [-R] mode,mode,... <path>...**

 					变化符合路径标识的一个或多个对象关联的文件权限....递归执行变更与R.模式是3位八进制模式，或{augo}+/-{rwxX}。假设如果没有指定范围，则不适用umask。

 					**chown [-R] [owner][:[group]] <path>...**

 					设置拥有用户和/或组标识路径的文件或目录....设置所有者递归，如果指定-R。

 					chgrp [-R] group <path>...

 					设置所属组标识路径的文件或目录....设置组递归，如果指定-R。

 					**help <cmd-name>**

 					返回使用上面列出的命令之一信息。必须省略了'-' 字符在cmd。			

 					 					 					 					 				

[![img](/static/images/adv/adv-a2.jpg)](https://www.bat888.cn/yibaijiaocheng/)

 	MapReduce它可以编写应用程序来处理海量数据，并行，大集群的普通硬件，以可靠的方式的框架。

##  MapReduce是什么?

 	MapReduce是一种处理技术和程序模型基于Java的分布式计算。 MapReduce算法包含了两项重要任务，即Map 和 Reduce。Map采用了一组数据，并将其转换成另一组数据，其中，各个元件被分解成元组(键/值对)。其次，减少任务，这需要从Map 作为输入并组合那些数据元组成的一组小的元组输出。作为MapReduce暗示的名称的序列在Map作业之后执行reduce任务。

 	MapReduce主要优点是，它很容易大规模数据处理在多个计算节点。下面MapReduce模型中，数据处理的原语被称为映射器和减速器。分解数据处理应用到映射器和减速器有时是普通的。但是编写MapReduce形式的应用，扩展应用程序运行在几百，几千，甚至几万机集群中的仅仅是一个配置的更改。这个简单的可扩展性是吸引了众多程序员使用MapReduce模型。

##  算法

- 通常MapReduce范例是基于向发送计算机数据的位置！
     MapReduce计划分三个阶段执行，即映射阶段，shuffle阶段，并减少阶段。
     -  					映射阶段：映射或映射器的工作是处理输入数据。一般输入数据是在文件或目录的形式，并且被存储在Hadoop的文件系统（HDFS）。输入文件被传递到由线映射器功能线路。映射器处理该数据，并创建数据的若干小块。
          减少阶段：这个阶段是：Shuffle阶段和Reduce阶段的组合。减速器的工作是处理该来自映射器中的数据。处理之后，它产生一组新的输出，这将被存储在HDFS。
          			在一个MapReduce工作，Hadoop的发送Map和Reduce任务到集群的相应服务器。
          			框架管理数据传递例如发出任务的所有节点之间的集群周围的详细信息，验证任务完成，和复制数据。
          			大部分的计算发生在与在本地磁盘上，可以减少网络通信量数据的节点。
          			给定的任务完成后，将群集收集并减少了数据，以形成一个合适的结果，并且将其发送回Hadoop服务器。

     #### 简述hadoop怎样实现二级排序？

     --在MapReduce中本身就会对我们key进行排序，所以我们要对value进行排序，主要思想为将key和部分value拼接成一个组合key（实现WritableComparable接口或者调用setSortComparatorClass函数），这样reduce获取的结果便是先按照key排序，后按value排序的结果，在这个方法中，用户需要自己实现Partioner，继承Partitioner<>，以便按照key进行数据划分。Hadoop显式的支持二次排序  ，在Configuration类中有个setGroupingComparatorClass()方法，可用于设置排序group的key值。

     #### 简述mapReduce中，combiner, partition作用？

     --在MapReduce整个过程中，combiner是可有可无的，需要是自己的情况而定，如果只是单纯的对map输出的key-value进行一个统计，则不需要进行combiner,combiner相当于提前做了一个reduce工作，减轻了reduce端的压力, Combiner只适用于那种Reduce的输入（key：value与输出（key:value））类型完全一致，而且不影响最终结果的场景。比如累加，最大值等， 也可以用于过滤数据，在map端将无效的数据过滤掉。输出的数据是可以根据key值来作合并的，合并的目的是减少输出的数据量。减少IO的读写，减少网络传输，以提高MR的作业效率。

     1. combiner的作用是在map端对输出先做一次合并，以减少传输到reducer的数据量

     2. combiner最基本是实现本地key的归并，具有类似本地的reduce，那么所有的结果都是reduce完成效率会相对降低。

     3. 使用combiner，先完成的map会在本地聚合，提升速度 

        --partition意思分开分区。它分割Map每个接节点的结果，按照key分别映射给不同的reduce，也是可以自定义。理解为归类或者根据Key或value以及reduce的数量来决定当前的这对输出数据最终应给交由那个reduce task处理 partition的作用就是把这些数据归类。每个map任务会针对输出进行分区，以及对每一个reduce建立一个分区。划分分区由用户定义的partition函数控制，默认使用哈希函数来划分区域。

        

        ###  列举几个hadoop生态圈的组件并做简要描述

        1）Zookeeper:是一个开源的分布式应用程序协调服务,基于zookeeper可以实现同步服务，配置维护，命名服务。

        2）Flume:一个高可用的，高可靠的，分布式的海量日志采集、聚合和传输的系统。

        3）Hbase:是一个分布式的、面向列的开源数据库, 利用Hadoop HDFS作为其存储系统。

        4）Hive:基于Hadoop的一个数据仓库工具，可以将结构化的数据档映射为一张数据库表，并提供简单的sql 查询功能，可以将sql语句转换为MapReduce任务进行运行。

        5）Sqoop:将一个关系型数据库中的数据导进到Hadoop的 HDFS中，也可以将HDFS的数据导进到关系型数据库中。

##  输入和输出（Java透视图）

 	MapReduce框架上的<key, value>对操作，也就是框架视图的输入工作作为一组<key, value>对，并产生一组<key, value>对作为作业的输出可以在不同的类型。

 	键和值类在框架连载的方式，因此，需要实现接口。此外，键类必须实现可写，可比的接口，以方便框架排序。MapReduce工作的输入和输出类型：（输入）<k1, v1> ->映射 - ><k2, v2>-> reduce - ><k3, v3>（输出）。

|        | 输入           | 输出            |
| ------ | -------------- | --------------- |
| Map    | <k1, v1>       | list (<k2, v2>) |
| Reduce | <k2, list(v2)> | list (<k3, v3>) |

##  术语:

-  			**PayLoad** - 应用程序实现映射和减少功能，形成工作的核心。
     **Mapper** - 映射器的输入键/值对映射到一组中间键/值对。
       			**NamedNode** - 节点管理Hadoop分布式文件系统（HDFS）。
       			**DataNode** - 节点数据呈现在任何处理发生之前。
       			**MasterNode** - 节点所在JobTracker运行并接受来自客户端作业请求。
       			**SlaveNode** - 节点所在Map和Reduce程序运行。
       			**JobTracker** - 调度作业并跟踪作业分配给任务跟踪器。
       			**Task Tracker** - 跟踪任务和报告状态的JobTracker。
       			**Job** -程序在整个数据集映射器和减速的执行。
       			**Task** - 一个映射程序的执行或对数据的一个片段的减速器。
       			**Task Attempt** - 一种尝试的特定实例在SlaveNode执行任务。

### Hadoop序列化和java序列化对比：

Hadoop将对象序列化到流中，Java的序列化机制是不断的创建对象，但在Hadoop的序列化机制中，用户可以复用对象，这样就减少了Java对象的分配和回收，这样提高了应用效率。

序列化（serialization）是指把结构化对象转化为字节流，便于在网络上传输或写到磁盘进行永久存储。

反序列化（Deserilization）是序列化的逆过程。就是把字节流转换为结构化对象。

Hadoop序列化格式特点：紧凑：高效使用存储空间     快速：读写数据的额外开销小。

可扩展：可透明的读取老格式的数据      互操作：多语言表达

### 简述MapReduce的执行过程

Learn to love 7Mile   ---> MapReduce 运行的时候，通过Mapper运行的任务读取HDFS中的数据文件。然后调用自己的方法，处理数据，最后输出。Reducer任务会接收Mapper任务输出的数据，作为自己的输入数据，调用自己的方法，最后输出到HDFS的文件中。  

### 列举MapReduce常用接口类：

1. FileInputFormat是所有以文件作为数据源的InputFormat实现的基类， FileInputFormat保存作为job输入的所有的文件，并实现了对输入文件计算splits的方法。至于获得记录的方法由不同的子类TextInputFormat实现
2. InputSplit
3. OutputFormat主要用于描述输出数据的格式，它能够将用户提供的key/value对写入的特定格式的文件中。

##  重要命令:

 	所有的Hadoop命令是由$HADOOP_HOME/bin/hadoop命令调用。不带任何参数运行Hadoop脚本打印所有命令的描述。

 	**Usage :** hadoop [--config confdir] COMMAND

 	下表列出了可用的选项及其说明。

| 操作                         | 描述                                           |
| ---------------------------- | ---------------------------------------------- |
| namenode -format             | 格式化DFS文件系统。                            |
| secondarynamenode            | 运行DFS二次名称节点。                          |
| namenode                     | 运行DFS名称节点。                              |
| datanode                     | 运行DFS的Datanode。                            |
| dfsadmin                     | 运行DFS管理客户端。                            |
| mradmin                      | 运行映射，减少管理客户端。                     |
| fsck                         | 运行DFS文件系统检查工具。                      |
| fs                           | 运行一个通用的文件系统的用户客户端。           |
| balancer                     | 运行集群平衡工具。                             |
| oiv                          | 适用于离线FsImage查看器的fsimage。             |
| fetchdt                      | 从NameNode获取团令牌。                         |
| jobtracker                   | 运行MapReduce工作跟踪节点。                    |
| pipes                        | 运行管道的工作。                               |
| tasktracker                  | 运行MapReduce任务跟踪节点。                    |
| historyserver                | 运行作业历史记录服务器作为一个独立的守护进程。 |
| job                          | 操纵MapReduce工作。                            |
| queue                        | 获取有关作业队列信息。                         |
| version                      | 打印版本。                                     |
| jar <jar>                    | 运行一个jar文件。                              |
| distcp <srcurl> <desturl>    | 复制文件或目录的递归。                         |
| distcp2 <srcurl> <desturl>   | DistCp第2版。                                  |
| archive -archiveName NAME -p | 创建一个Hadoop的归档。                         |
| <parent path> <src>* <dest>  |                                                |
| classpath                    | 打印需要得到Hadoop jar和所需要的库的类路径。   |
| daemonlog                    | 为每个守护进程获取/设置日志级别                |

##  	如何与MapReduce工作互动

 	Usage: hadoop job [GENERIC_OPTIONS]

 	以下是在一个Hadoop的作业可用通用选项。

| GENERIC_OPTIONS                                         | 描述                                                         |
| ------------------------------------------------------- | ------------------------------------------------------------ |
| -submit <job-file>                                      | 提交作业。                                                   |
| status <job-id>                                         | 打印映射，并减少完成的百分比以及所有的工作的计数器。         |
| counter <job-id> <group-name> <countername>             | 打印的计数器值。                                             |
| -kill <job-id>                                          | 终止任务。                                                   |
| -events <job-id> <fromevent-#> <#-of-events>            | 打印接收到JobTracker为给定范围内的事件的详细信息。           |
| -history [all] <jobOutputDir> - history < jobOutputDir> | 打印作业的详细信息，未能终止提示详细信息。有关作业的更多详细信息，如每个任务取得成功的任务，任务可以尝试通过指定[all]选项中查看。 |
| -list[all]                                              | 显示所有作业。-list 只显示尚未完成的作业。                   |
| -kill-task <task-id>                                    | 终止任务。终止任务不计入失败的尝试。                         |
| -fail-task <task-id>                                    | 失败的任务。失败的任务都算对失败的尝试。                     |
|                                                         |                                                              |
| set-priority <job-id> <priority>                        | 更改作业的优先级。允许优先级值：VERY_HIGH, HIGH, NORMAL, LOW, VERY_LOW |

### hadoop block 大小为128的原因：

1. 减轻了namenode的压力 hadoop集群在启动的时候，datanode会报上自己的block的信息给namenode。 namenode把这些信息放到内存中。那么如果块变大了，那么namenode的记录的信息相对减少，所以namenode就有更多的内存去做的别的事情，使得整个集群的性能增强。
2. 增大会不会带来负面相应 因为这个可以灵活设置，所以这里不是问题，关键是什么时候，该如何处置。 如果对于数量级别为PB的话，可以建议将block设置大一些。 如果数据量相对较少，可以设置小一些64M也可以。负面效应，如果网络环境不好，会造成重新传输。
3. 如果寻址时间约为10ms，而传输速率为100mb/s， 为了使寻址时间仅占传输时间的64M.

	##  	要查看作业的状态

```shell
$ $HADOOP_HOME/bin/hadoop job -status <JOB-ID> 
e.g. 
$ $HADOOP_HOME/bin/hadoop job -status job_201310191043_0004 
```

###  	要查看作业历史在output-dir

```shell
$ $HADOOP_HOME/bin/hadoop job -history <DIR-NAME> 
e.g. 
$ $HADOOP_HOME/bin/hadoop job -history /user/expert/output 
```

###  	终止任务

```shell
$ $HADOOP_HOME/bin/hadoop job -kill <JOB-ID> 
e.g. 
$ $HADOOP_HOME/bin/hadoop job -kill job_201310191043_0004 
```

#  开发前提：

在Linux上开发 - Ubuntu操作系统

已经安装了Hadoop(使用版本2.7.1)

系统上已安装了Java(使用 JDK1.8.0)。

 步骤:

 	1.创建一个新的目录名称是：MapReduceTutorial

```shell
hduser_@ubuntu:~$ sudo mkdir MapReduceTuorial
```

 	**授予权限**

```shell
hduser_@ubuntu:~$ sudo chmod -R 777 MapReduceTutorial
```

 安装

```shell
sudo apt-get install openjdk-8-jdk
```

(3) 配置环境变量, 编辑如下文件:

```shell
vim ~/.bashrc
```

在最后一行加:

```shell
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

(4) 测试jdk是否安装成功:

```shell
java -version
openjdk version “1.8.0_91” 
OpenJDK Runtime Environment (build 1.8.0_91-8u91-b14-0ubuntu4~15.10.1-b14) 
OpenJDK Server VM (build 25.91-b14, mixed mode)
```

 Ubuntu: 下载Hadoop:

```shell
sudo wget http://mirrors.shu.edu.cn/apache/hadoop/common/hadoop-2.8.4/hadoop-2.8.4.tar.gz
```

 注意：Error：JAVA_HOME is not set and could not be found 解决办法

需要更改hadoop里面 hadoop-env.sh文件里面的java 路径设置， hadoop-env.sh在hadoop/etc/hadoop目录下，具体的修改方法：

```shell
sudo vim hadoop/etc/hadoop/hadoop-env.sh
将语句 export JAVA_HOME=$JAVA_HOME 改为 export JAVA_HOME=/usr/java/jdk1.8.0_101
:wq!  强制保存退出
```

 hadoop:未找到命令   ------->使用./sbin/start-all.sh

或：$vi/etc/profile 修改环境变量导致系统无法进入桌面环境。所以换一种方式添加环境变量即：通过shell命令export修改Linux环境变量。

```shell
$export PATH=$PATH:/usr/local/hadoop/bin
```

 出现: master running as process 10729. Stop it first

解决办法：查看配置文件hbase-site.xml是不是写错了。要用HDFS为Hbase提供存储空间，定义hbase.rootdir参数时HDFS文件系统的主机名和端口号必须与Hadoop的配置文件core-site.xml中fs.default.name参数的配置一致 

```xml
<configuration>
    <property>
        <name>hbase.rootdir</name>
        <value>hdfs://localhost:9000</value>
        <description>此参数指定了HRegion服务器的位置，即数据存放位置</description>
    </property>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
        <description>此参数指定了Hlog和Hfile的副本个数，此参数的设置不能大于HDFS的节点数。伪分布式下DataNode只有一台，因此此参数应设置为1
         </description>
    </property>
 <property>
    <name>hadoop.tmp.dir</name>
    <value>file:/usr/local/hadoop/tmp</value>
    <description>namenode上本地的hadoop临时文件夹</description>
</property>
</configuration>
```

出现其他eg. nodemanager is running as process 13673. Stop it first.   需要停掉所有服务重新启动即可。

检测是否启动成功用jps

启动服务后发现没有datanode在hadoop启动hdf服务的时候，会分别启动namenode和datanode两个节点，在hdfs-site.xml文件中设置的namenode和datanode里面会有对应的路径，我的路径分别是 

```xml
<configuration>
<property>  
        <name>dfs.namenode.data.dir</name>  
        <value>file:/usr/local/temp/hadoop/namenode</value>  
    </property>  
    <property>  
        <name>dfs.datanode.data.dir</name>  
        <value>file:/usr/local/temp/hadoop/datanode</value>  
    </property>  
    <property>  
        <name>dfs.replication</name>  
        <value>1</value>  
    </property>  

</configuration>
```

然后去对应的目录
下面时datanode的VERSION

root@ubuntu:/usr/local/temp/hadoop/datanode/current# cat VERSION 

Wed Nov 28 00:13:54 PST 2018

storageID=DS-7c51b817-fffc-4cdf-8baa-ac119fec47af
clusterID=CID-f52422a5-0ee9-46a2-bb8b-e7cc19771af5
cTime=0
datanodeUuid=559dc6f6-6c85-41b9-afc0-07c5672a64da
storageType=DATA_NODE
layoutVersion=-57
root@ubuntu:/usr/local/temp/hadoop/datanode/current# 

namenode 的VERSION

root@ubuntu:/usr/local/temp/hadoop/namenode/current# cat VERSION 

namespaceID=203824828
clusterID=CID-f52422a5-0ee9-46a2-bb8b-e7cc19771af4
cTime=1543388780695
storageType=NAME_NODE
blockpoolID=BP-1502030832-127.0.0.1-1543388780695

layoutVersion=-63

##### 如果出现： It looks like you are making an HTTP request to a Hadoop IPC port. This is not the correct port for the web interface on this daemon.

解决方案：之前配置的localhost:9000是单节点。 正确的为http://localhost:8088/cluster

管理界面：http://localhost:8088       NameNode界面：http://localhost:50070    ---->port to 9870

HDFS NameNode界面： http://localhost:8042

##### Hadoop】 NameNode无法启动，日志提示file:/// has no authority，导致不能访问50070端口

 

```verilog
FATAL org.apache.hadoop.hdfs.server.namenode.NameNode: Failed to start namenode.
java.lang.IllegalArgumentException: Invalid URI for NameNode address (check fs.defaultFS): file:/// has no authority.
        at org.apache.hadoop.hdfs.server.namenode.NameNode.getAddress(NameNode.java:420)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.getAddress(NameNode.java:410)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.getRpcServerAddress(NameNode.java:461)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.loginAsNameNodeUser(NameNode.java:561)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.initialize(NameNode.java:581)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.<init>(NameNode.java:756)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.<init>(NameNode.java:740)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.createNameNode(NameNode.java:1430)
        at org.apache.hadoop.hdfs.server.namenode.NameNode.main(NameNode.java:1496)
2018-08-05 13:24:26,411 INFO org.apache.hadoop.util.ExitUtil: Exiting with status 1
2018-08-05 13:24:26,413 INFO org.apache.hadoop.hdfs.server.namenode.NameNode: SHUTDOWN_MSG:
SHUTDOWN_MSG: Shutting down NameNode at qqqweqwe.com/192.168.228.3
    
解决方案：
    
    原core-site.xml配置为：
 <property>
    <name>fs.defaultFS</name>
    <value>hdfs://localhost:9000</value>
 </property>

解决方法：

修改core-site.xml文件
 <property>
    <name>fs.default.name</name>
    <value>hdfs://localhost:9000</value>
 </property>
```

执行 NameNode 的格式化:

```shell
./bin hadoop namenode -format
```

hadoop格式化namenode时报异常： URI has an authority component 

错误原因是hdfs-site.xml配置文件中dfs.namenode.name.dir

##### **hadoop3.X的webUI已经改到端口 localhost:9870上面，而不是原来的50070** 

创建测试文件、

```shell
#查看hdfs上的目录
hadoop fs -ls /
#创建input目录，源数据的存放地
hadoop fs -mkdir /input
#如果有output目录，删除，把结果集输出到这里，事先不能存在
hadoop fs -rm r /output
#把提前准备好的文本文件上传到hdfs的/input目录
hadoop fs -put /home/hadoop/data/*.txt /input 
#如果创建了目录就直接在目录下面创建文件
hdfs dfs -mkdir -p /usr/hello.txt
#执行程序的wordcount
cd /usr/local/hadoop/hadoop-3.2.0/share/hadoop/mapreduce/
hadoop jar hadoop-mapreduce-examples-3.2.0.jar wordcount /input /output
#查看hdfs 上/output 生成的结果
hadoop fs -ls /output
#输出词频统计结果
hadoop fs -cat /output/part-r-00000
```

如果连接不上192.168.56.101:9000 connected refused --->netstat -tpnl 显示127.0.0.1:9000 

解决方案：sudo vim /etc/host  把localhost 更改为0.0.0.0

hadoop dfsadmin -report 命令查看磁盘使用情况

##### Hadoop上传文件报错could only be written to 0 of the 1 minReplication nodes.

```shell
jps指令 NodeManager   ResourceManager   NameNode  SecondaryNameNode   Jps都有
hadoop dfsadmin -report #查看磁盘使用情况参数都是0
问题：由于使用hadoop namenode -format 格式化多次，导致spaceID不一致造成的，解决办法是
1. 停止集群所有的服务，指令： stop-all.sh
2. 删除hdfs中配置的data目录下的所有文件（core-site.xml中配置的hadoop.tmp.dir）
指令为： rm -rf /xxx/xxx/tmp/*
3. 重新格式化namenode， 指令为: hadoop namenode -format
4. 重新启动hadoop集群。指令为：start-all.sh
```

运行wordcount示例：hadoop jar /usr/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.4.jar wordcount /input /output  

No live node

```xml
解决方案： 在 hdfs-site.xml 中加
<property>
    <name>dfs.datanode.max.xcievers</name>
    <value>4096</value>
    <dedication>Datanode有一个同时处理文件的上限，至少要有4096</dedication>
</property>   
```

##### Error: JAVA_HOME is incorrectly set. Please update F:\hadoop\conf\hadoop-env.cmd解决方法

原来是配置文件的问题，我的JAVA_HOME目录是C:\Program Files\Java\jdk1.8.0_121，因为Program Files中存在空格，所以出现错误，只需要用

PROGRA~1代替Program Files即可，即改为C:\PROGRA~1\Java\jdk1.8.0_121，当然，你也可以讲jdk装到根目录或者不存在空格等目录下。

hadoop环境搭建好后，运行第wordcount示例
1.首先启动hadoop：sbin/start-dfs.sh,sbin/start-yarn.sh（必须能够正常运行）

2.进入到hadoop的安装目录下（我的是/usr/hadoop）

3.新建hadoop hdfs文件系统上的input文件夹（输入文件存放）：hadoop fs -mkdir /input

4.传入测试文件：hadoop fs -put test.txt /input （这里我是在hadoop安转目录建了一个test.txt文件）

查看刚刚传入的文件：hadoop fs -ls /input


5.运行wordcount示例：hadoop jar /usr/hadoop/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.4.jar wordcount /input /output （下划线具体路径自己调整）。


6.运行成功后，查看目录：hadoop fs -ls / 多了一个output文件夹

继续查看 output 文件夹：hadoop fs -ls /output
有 _SUCCESS 和part-r-00000两个文件夹

7.查看part-r-00000 文件夹中的运行结果：hadoop fs -cat /output/part-r-00000

8.访问50070端口也可查看 ，输入master的ip 访问：http://192.168.184.131:50070

进入input文件夹就可看到上传的test.txt文件

```shell
hadoop@fei-VirtualBox:/usr/local/hadoop/hadoop/share/hadoop/mapreduce$ hadoop jar hadoop-mapreduce-examples-3.2.0.jar wordcount /user/hadoop output
2019-07-26 11:04:25,907 INFO impl.MetricsConfig: Loaded properties from hadoop-metrics2.properties
2019-07-26 11:04:26,084 INFO impl.MetricsSystemImpl: Scheduled Metric snapshot period at 10 second(s).
2019-07-26 11:04:26,084 INFO impl.MetricsSystemImpl: JobTracker metrics system started
2019-07-26 11:04:27,137 INFO input.FileInputFormat: Total input files to process : 1
2019-07-26 11:04:27,189 INFO mapreduce.JobSubmitter: number of splits:1
2019-07-26 11:04:27,476 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local200834842_0001
2019-07-26 11:04:27,480 INFO mapreduce.JobSubmitter: Executing with tokens: []
2019-07-26 11:04:27,717 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
2019-07-26 11:04:27,718 INFO mapreduce.Job: Running job: job_local200834842_0001
2019-07-26 11:04:27,729 INFO mapred.LocalJobRunner: OutputCommitter set in config null
2019-07-26 11:04:27,745 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 2
2019-07-26 11:04:27,746 INFO output.FileOutputCommitter: FileOutputCommitter skip cleanup _temporary folders under output directory:false, ignore cleanup failures: false
2019-07-26 11:04:27,749 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
2019-07-26 11:04:27,852 INFO mapred.LocalJobRunner: Waiting for map tasks
2019-07-26 11:04:27,853 INFO mapred.LocalJobRunner: Starting task: attempt_local200834842_0001_m_000000_0
2019-07-26 11:04:27,901 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 2
2019-07-26 11:04:27,903 INFO output.FileOutputCommitter: FileOutputCommitter skip cleanup _temporary folders under output directory:false, ignore cleanup failures: false
2019-07-26 11:04:27,950 INFO mapred.Task:  Using ResourceCalculatorProcessTree : [ ]
2019-07-26 11:04:27,964 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/hadoop/hello.txt:0+50
2019-07-26 11:04:28,116 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
2019-07-26 11:04:28,116 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
2019-07-26 11:04:28,116 INFO mapred.MapTask: soft limit at 83886080
2019-07-26 11:04:28,116 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
2019-07-26 11:04:28,117 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
2019-07-26 11:04:28,131 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
2019-07-26 11:04:28,462 INFO mapred.LocalJobRunner: 
2019-07-26 11:04:28,465 INFO mapred.MapTask: Starting flush of map output
2019-07-26 11:04:28,465 INFO mapred.MapTask: Spilling map output
2019-07-26 11:04:28,466 INFO mapred.MapTask: bufstart = 0; bufend = 86; bufvoid = 104857600
2019-07-26 11:04:28,467 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214364(104857456); length = 33/6553600
2019-07-26 11:04:28,486 INFO mapred.MapTask: Finished spill 0
2019-07-26 11:04:28,508 INFO mapred.Task: Task:attempt_local200834842_0001_m_000000_0 is done. And is in the process of committing
2019-07-26 11:04:28,516 INFO mapred.LocalJobRunner: map
2019-07-26 11:04:28,520 INFO mapred.Task: Task 'attempt_local200834842_0001_m_000000_0' done.
2019-07-26 11:04:28,543 INFO mapred.Task: Final Counters for attempt_local200834842_0001_m_000000_0: Counters: 24
	File System Counters
		FILE: Number of bytes read=316737
		FILE: Number of bytes written=829987
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=50
		HDFS: Number of bytes written=0
		HDFS: Number of read operations=5
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=1
		HDFS: Number of bytes read erasure-coded=0
	Map-Reduce Framework
		Map input records=5
		Map output records=9
		Map output bytes=86
		Map output materialized bytes=110
		Input split bytes=108
		Combine input records=9
		Combine output records=9
		Spilled Records=9
		Failed Shuffles=0
		Merged Map outputs=0
		GC time elapsed (ms)=36
		Total committed heap usage (bytes)=232656896
	File Input Format Counters 
		Bytes Read=50
2019-07-26 11:04:28,547 INFO mapred.LocalJobRunner: Finishing task: attempt_local200834842_0001_m_000000_0
2019-07-26 11:04:28,548 INFO mapred.LocalJobRunner: map task executor complete.
2019-07-26 11:04:28,551 INFO mapred.LocalJobRunner: Waiting for reduce tasks
2019-07-26 11:04:28,552 INFO mapred.LocalJobRunner: Starting task: attempt_local200834842_0001_r_000000_0
2019-07-26 11:04:28,574 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 2
2019-07-26 11:04:28,575 INFO output.FileOutputCommitter: FileOutputCommitter skip cleanup _temporary folders under output directory:false, ignore cleanup failures: false
2019-07-26 11:04:28,578 INFO mapred.Task:  Using ResourceCalculatorProcessTree : [ ]
2019-07-26 11:04:28,588 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@ca95b37
2019-07-26 11:04:28,593 WARN impl.MetricsSystemImpl: JobTracker metrics system already initialized!
2019-07-26 11:04:28,633 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=1416259200, maxSingleShuffleLimit=354064800, mergeThreshold=934731136, ioSortFactor=10, memToMemMergeOutputsThreshold=10
2019-07-26 11:04:28,656 INFO reduce.EventFetcher: attempt_local200834842_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
2019-07-26 11:04:28,708 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local200834842_0001_m_000000_0 decomp: 106 len: 110 to MEMORY
2019-07-26 11:04:28,723 INFO reduce.InMemoryMapOutput: Read 106 bytes from map-output for attempt_local200834842_0001_m_000000_0
2019-07-26 11:04:28,725 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 106, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->106
2019-07-26 11:04:28,730 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
2019-07-26 11:04:28,732 INFO mapred.LocalJobRunner: 1 / 1 copied.
2019-07-26 11:04:28,733 INFO reduce.MergeManagerImpl: finalMerge called with 1 in-memory map-outputs and 0 on-disk map-outputs
2019-07-26 11:04:28,737 INFO mapreduce.Job: Job job_local200834842_0001 running in uber mode : false
2019-07-26 11:04:28,739 INFO mapreduce.Job:  map 100% reduce 0%
2019-07-26 11:04:28,756 INFO mapred.Merger: Merging 1 sorted segments
2019-07-26 11:04:28,757 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 102 bytes
2019-07-26 11:04:28,762 INFO reduce.MergeManagerImpl: Merged 1 segments, 106 bytes to disk to satisfy reduce memory limit
2019-07-26 11:04:28,762 INFO reduce.MergeManagerImpl: Merging 1 files, 110 bytes from disk
2019-07-26 11:04:28,763 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
2019-07-26 11:04:28,767 INFO mapred.Merger: Merging 1 sorted segments
2019-07-26 11:04:28,772 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 102 bytes
2019-07-26 11:04:28,774 INFO mapred.LocalJobRunner: 1 / 1 copied.
2019-07-26 11:04:28,859 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
2019-07-26 11:04:29,432 INFO mapred.Task: Task:attempt_local200834842_0001_r_000000_0 is done. And is in the process of committing
2019-07-26 11:04:29,457 INFO mapred.LocalJobRunner: 1 / 1 copied.
2019-07-26 11:04:29,460 INFO mapred.Task: Task attempt_local200834842_0001_r_000000_0 is allowed to commit now
2019-07-26 11:04:29,511 INFO output.FileOutputCommitter: Saved output of task 'attempt_local200834842_0001_r_000000_0' to hdfs://localhost:9000/user/hadoop/output
2019-07-26 11:04:29,513 INFO mapred.LocalJobRunner: reduce > reduce
2019-07-26 11:04:29,514 INFO mapred.Task: Task 'attempt_local200834842_0001_r_000000_0' done.
2019-07-26 11:04:29,520 INFO mapred.Task: Final Counters for attempt_local200834842_0001_r_000000_0: Counters: 30
	File System Counters
		FILE: Number of bytes read=316989
		FILE: Number of bytes written=830097
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=50
		HDFS: Number of bytes written=68
		HDFS: Number of read operations=10
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=3
		HDFS: Number of bytes read erasure-coded=0
	Map-Reduce Framework
		Combine input records=0
		Combine output records=0
		Reduce input groups=9
		Reduce shuffle bytes=110
		Reduce input records=9
		Reduce output records=9
		Spilled Records=9
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=4
		Total committed heap usage (bytes)=232656896
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Output Format Counters 
		Bytes Written=68
2019-07-26 11:04:29,534 INFO mapred.LocalJobRunner: Finishing task: attempt_local200834842_0001_r_000000_0
2019-07-26 11:04:29,534 INFO mapred.LocalJobRunner: reduce task executor complete.
2019-07-26 11:04:29,740 INFO mapreduce.Job:  map 100% reduce 100%
2019-07-26 11:04:29,741 INFO mapreduce.Job: Job job_local200834842_0001 completed successfully
2019-07-26 11:04:29,764 INFO mapreduce.Job: Counters: 36
	File System Counters
		FILE: Number of bytes read=633726
		FILE: Number of bytes written=1660084
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=100
		HDFS: Number of bytes written=68
		HDFS: Number of read operations=15
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=4
		HDFS: Number of bytes read erasure-coded=0
	Map-Reduce Framework
		Map input records=5
		Map output records=9
		Map output bytes=86
		Map output materialized bytes=110
		Input split bytes=108
		Combine input records=9
		Combine output records=9
		Reduce input groups=9
		Reduce shuffle bytes=110
		Reduce input records=9
		Reduce output records=9
		Spilled Records=18
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=40
		Total committed heap usage (bytes)=465313792
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=50
	File Output Format Counters 
		Bytes Written=68
hadoop@fei-VirtualBox:/usr/local/hadoop/hadoop/share/hadoop/mapreduce$ hadoop fs -ls /
Found 2 items
drwxr-xr-x   - hadoop supergroup          0 2019-07-26 10:57 /output
drwxr-xr-x   - hadoop supergroup          0 2019-07-23 14:20 /user
hadoop@fei-VirtualBox:/usr/local/hadoop/hadoop/share/hadoop/mapreduce$ hadoop fs -cat /user/hadoop/output/part-r-00000
I	1
a	1
aaaa	1
am	1
bbbbb	1
cccccc	1
demo	1
hello.java	1
test!!!!	1
```



---------------------
##### Hadoop应用场景：

有一个100M 的数据库备份的sql 文件.我现在想在不导入到数据库的情况下直接用grep操作通过正则过滤出我想要的内容。例如：某个表中含有相同关键字的记录，有几种方式,一种是直接用linux的命令 grep 还有一种就是通过编程来读取文件,然后对每行数据进行正则匹配得到结果好了 现在是100M 的数据库备份.上述两种方法都可以轻松应对. 那么如果是1G , 1T 甚至 1PB 的数据呢 ,上面2种方法还能行得通吗？ 答案是不能.毕竟单台服务器的性能总有其上限.那么对于这种 超大数据文件怎么得到我们想要的结果呢？ 有种方法 就是分布式计算, 分布式计算的核心就在于 利用分布式算法 把运行在单台机器上的程序扩展到多台机器上并行运行.从而使数据处理能力成倍增加.但是这种分布式计算一般对编程人员要求很高,而且对服务器也有要求.导致了成本变得非常高. Hadoop 就是为了解决这个问题诞生的.Hadoop 可以很轻易的把很多linux的廉价pc 组成分布式结点,然后编程人员也不需要知道分布式算法之类,只需要根据mapreduce的规则定义好接口方法,剩下的就交给Haddop. 它会自动把相关的计算分布到各个结点上去,然后得出结果. 例如上述的例子 ： Hadoop 要做的事 首先把 1PB的数据文件导入到 HDFS中, 然后编程人员定义好 map和reduce, 也就是把文件的行定义为key,每行的内容定义为value , 然后进行正则匹配,匹配成功则把结果 通过reduce聚合起来返回.Hadoop 就会把这个程序分布到N 个结点去并行的操作. 那么原本可能需要计算好几天,在有了足够多的结点之后就可以把时间缩小到几小时之内. 

- 大数据量存储：分布式存储（各种云盘，百度，360~还有云平台均有hadoop应用）
- 日志处理: Hadoop擅长这个
- 海量计算: 并行计算
- ETL:数据抽取到oracle、mysql、DB2、mongdb及主流数据库
- 使用HBase做数据分析: 用扩展性应对大量读写操作—Facebook构建了基于HBase的实时数据分析系统
- 机器学习: 比如Apache Mahout项目（[Apache Mahout简介](http://www.cnblogs.com/shipengzhi/articles/2489437.html) 常见领域：协作筛选、集群、归类）
- 搜索引擎:hadoop + lucene实现
- 数据挖掘：目前比较流行的广告推荐
- 大量地从文件中顺序读。HDFS对顺序读进行了优化，代价是对于随机的访问负载较高。
- 用户行为特征建模
- 个性化广告推荐
- 智能仪器推荐

# Elasticsearch Outline:

Elasticsearch: 分布式的RESTful风格的搜索和数据分析引擎。

查询：Elasticsearch允许执行和合并多种类型的搜索--结构化、非结构化、地理位置

HADOOP & SPARK:  Elasticsearch + Hadoop

高度可伸缩的开源全文搜索和分析引擎。它允许快速和接近实时地存储、搜索和分析大量数据。

#### 基本概念：

##### Near Realtime (NRT)

Elasticsearchs是近乎实时的搜索平台，搜索的时间延迟通常1秒 。

##### Cluster

集群是一个或者多个节点（服务器）的集合，它们共同保存整个数据，并提供跨所有节点的联合索引和搜索功能。一个集群由一个唯一的名称标识，默认整个唯一标识的名称是“elasticsearch”。 这个名称很重要，因为如果节点被设置为按其名称加入集群，那么节点只能是集群的一部分。

##### Node

节点是一个单独的服务器，它是集群的一部分，存储数据，并参与集群的索引的搜索功能。就像集群一样，节点由一个名称来标识，默认情况下该名称是在启动时分配给节点的随机通用唯一标识符（UUID）。如果不想用默认的节点名，可以定义任何想要的节点名。这个名称对于管理者很重要。 一个节点可以通过配置集群名称来加入到一个特定的集群中。默认情况下，每个节点都被设置加入到一个名字叫“elasticsearch”的集群中，这就意味着如果启动了很多个 节点，并且假设彼此可以相互发现，它们自动形成加入到名为“elasticsearch”的集群中。 一个集群可以有任意数量的点。 此外，如果在你的网络上当前没有运行任何节点，那么此时启动一个节点将默认形成一个单节点的名字叫“elasticsearch”的集群。

##### Index

索引是具有某种相似特征的文档的集合。例如，一个客户数据索引，产品目录索引和订单数据索引。索引有一个名称（必须是小写的）标识，该名称用于在对其中的文档执行索引、搜索、更新和删除操作时引用索引。

##### Document

文档是可以被索引的基本信息单元。文档用json表示

##### Shards & Replicas

一个索引可能存储大量的数据，这些数据可以超过单个节点的硬件限制。例如， 一个包含10亿万条文档占用1TB磁盘空间的索引可能不适合在单个节点上，或者可能太慢而不能单独处理来自单个节点的搜索请求。为了解决问题，Elasticsearch提供了将索引分多个碎片（或者叫做分片的能力）。创建索引的时候，可以简单地定义所需分片的数量。每个分片本身就是个功能完全独立的“索引”， 可以驻留在集群中的任何节点上。或者可能太慢而不能单独处理来自单个几点的搜素请求。分片重要的原因：1.它允许水平的分割/扩展内容卷

​			     2.它允许跨分片（可能在多个节点上）分布和并行操作，从而提高性能和吞吐量

每个索引都分配了5个主分片的和一个副本，如果集群中至少两个节点，那么索引将有5个主分片和另外5个副分片（PS：这5个副本分片组成一个完整副本），每个索引总共有10个分片。	 

#### 底层算法：

Elasticsearch为了能快速找到某个term，将所有的term排个序，二分法查找term，logN的查找效率，就像通过字典查找一样，这就是**Term Dictionary**。 B-Tree通过减少磁盘寻道次数来提高查询性能，Elasticsearch也是采用同样的思路，直接通过内存查找term，不读磁盘，但是如果term太多，term dictionary也会很大，放内存不现实，于是有了**Term Index**，就像字典里的索引页一样 。

##### Elasticsearch的索引思路:

> 将磁盘里的东西尽量搬进内存，减少磁盘随机读取次数(同时也利用磁盘顺序读特性)，结合各种奇技淫巧的压缩算法，用及其苛刻的态度使用内存。

所以，对于使用Elasticsearch进行索引时需要注意:

- 不需要索引的字段，一定要明确定义出来，因为默认是自动建索引的
- 同样的道理，对于String类型的字段，不需要analysis的也需要明确定义出来，因为默认也是会analysis的
- 选择有规律的ID很重要，随机性太大的ID(比如java的UUID)不利于查询

##### 启动相关错误：

【1】java.nio.file.AccessDeniedException: /data/wwwroot/elasticsearch-6.2.4/config/jvm.options 

原因：当前用户没有执行权限 
解决方法： chown linux用户名 elasticsearch安装目录 -R 
例如：chown ealsticsearch /data/wwwroot/elasticsearch-6.2.4 -R 

PS：其他Java软件报.AccessDeniedException错误也可以同样方式解决，给 执行用户相应的目录权限即可

【2】elasticsearch运行后外部访问不到问题

通过命令netstat -aon|grep 9200查询发现elasticsearch默认绑定host是127.0.0.1。

修改config/elasticsearch.yml

添加network.host: 你的服务器ip

然后在启动，外部就能访问了

【3】expecting token of type [START_OBJECT] but found [VALUE_STRING]]; 
报错详细信息：

SettingsException[Failed to load settings from [elasticsearch.yml]]; nested: ParsingException[Failed to parse object: expecting token of type [START_OBJECT] but found [VALUE_STRING]]; 

错误原因：elasticsearch.yml 文件内部错误 

解决办法：仔细检查yml文件中的配置项书写格式： （空格）name：（空格）value

【4】报错详细信息：这个属于bootstrap checks failed报错大类中的几个，所以没什么详细描述 

错误原因：系统设置错误，系统为es分配的配置不够 
解决办法：（如果还报这个错误就说明分配的大小还需要调整，依据报错信息来，因为es在不断地更新，未来要求的内存大小可能更高，我猜的>_<）

切换到root用户    
1、vi /etc/security/limits.conf 修改如下配置
* soft nofile 65536
* hard nofile 131072
* soft nproc 2048
* hard nproc 4096

2、vi /etc/security/limits.d/90-nproc.conf   修改如下配置
* soft nproc 2048

3、vi /etc/sysctl.conf 添加配置
vm.max_map_count=655360 

运行命令 sysctl -p

Java连接elasticsearch 必需要引入log4j2 否则报错

# Spark Outline:

Spark Streaming：构建在Spark上处理Stream数据的框架，基本的原理是将Stream数据分成小的时间片段（几秒），以类似batch批量处理的方式来处理这小部分数据。Spark Streaming构建在Spark上，一方面是因为Spark的低延迟执行引擎（100ms+），虽然比不上专门的流式数据处理软件，也可以用于实时计算，另一方面相比基于Record的其它处理框架（如Storm），一部分窄依赖的RDD数据集可以从源数据重新计算达到容错处理目的。此外小批量处理的方式使得它可以同时兼容批量和实时数据处理的逻辑和算法。 

**中间结果输出**：基于MapReduce的计算引擎通常会将中间结果输出到磁盘上，进行存储和容错。出于任务管道承接的，考虑，当一些查询翻译到MapReduce任务时，往往会产生多个Stage，而这些串联的Stage又依赖于底层文件系统（如HDFS）来存储每一个Stage的输出结果。

**Spark是MapReduce的替代方案，而且兼容HDFS、Hive，可融入Hadoop的生态系统，以弥补MapReduce的不足。**

##### Spark组成：

Spark组成(BDAS)：全称伯克利数据分析栈，通过大规模集成算法、机器、人之间展现大数据应用的一个平台。也是处理大数据、云计算、通信的技术解决方案。

它的主要组件有：

**SparkCore**：将分布式数据抽象为弹性分布式数据集（RDD），实现了应用任务调度、RPC、序列化和压缩，并为运行在其上的上层组件提供API。

**SparkSQL**：Spark Sql 是Spark来操作结构化数据的程序包，可以让我使用SQL语句的方式来查询数据，Spark支持 多种数据源，包含Hive表，parquest以及JSON等内容。

**SparkStreaming**： 是Spark提供的实时数据进行流式计算的组件。

**MLlib**：提供常用机器学习算法的实现库。

**GraphX**：提供一个分布式图计算框架，能高效进行图计算。

**BlinkDB**：用于在海量数据上进行交互式SQL的近似查询引擎。

**Tachyon**：以内存为中心高容错的的分布式文件系统。

# Hadoop数据库：

**Hive**是基于Hadoop的一个数据仓库工具，可以将结构化的数据文件映射为一张数据库表，并提供简单的sql查询功能，可以将sql语句转换为MapReduce任务进行运行。**HBase**是Hadoop的数据库，一个分布式、可扩展、大数据的存储。 

#### Hive和Hbase的区别？

Hive帮助熟悉SQL的人运行MapReduce任务。因为它是JDBC兼容的，同时，它也能够和现存的SQL工具整合在一起。运行Hive查询会花费很长时间，因为它会默认遍历表中所有的数据。虽然有这样的缺点，一次遍历的数据量可以通过Hive的分区机制来控制。分区允许在数据集上运行过滤查询，这些数据集存储在不同的文件夹内，查询的时候只遍历指定文件夹(分区)中的数据。这种机制可以用来，例如，只处理在某一个时间范围内的文件，只要这些文件名中包括了时间格式。

HBase通过存储key/value来工作。它支持四种主要的操作：增加或者更新行，查看一个范围内的cell，获取指定的行，删除指定的行、列或者是列的版本。版本信息用来获取历史数据(每一行的历史数据可以被删除，然后通过Hbase compactions就可以释放出空间)。虽然HBase包括表格，但是schema仅仅被表格和列簇所要求，列不需要schema。Hbase的表格包括增加/计数功能。