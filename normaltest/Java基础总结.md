

##### 基本数据类型：![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110205844640.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### 包装类型：

包装类型是对基本数据类型不足之处的补充。

基本数据类型的传递方式是值传递，而包装类型是引用传递，同时提供了很多数据类型间转换的方法。

Java1.5 以后可以自动装箱和拆箱。

##### 抽象类:

 * 1、抽象类中可以没有抽方法；

 * 2、抽象类中既可以有抽象方法，也可以有普通方法；

 * 3、一个类中只要有一个抽象方法，那么这个类就必须是抽象类；

 * 4、一个类继承一个抽象类必须重写所有的抽象方法，否则这个类就是抽象类；

 * 5、抽象类可以作为参数传递；

 * 6、当方法的参数是抽象类或者接口时，调用这个方法需要抽象类的子类或者接口的实现类。

 * 7、static修饰的数据在一个对象中修改后，共享数据区中的数据就会被修改；

* 8、final修饰的变量、方法、类不可被修改；

* ### 9、static final修饰的数据为常量。
##### hash值：

HASH是根据文件的内容的数据通过逻辑运算得到的数值, 不同的文件(即使是相同的文件名)得到的HASH值是不同的, 所以HASH值就成了每一个文件在EMULE里的身份证. 不同HASH值的文件在EMULE里被认为是不同的文件,相同的HASH值的文件的内容肯定是完全相同(即使文件名不同). HASH值还有文件校验的功能,相当于文件的校验码. 所以还可以用来检查文件下载是否正确(所以EMULE下载完毕时,都会在HASH文件一遍, 检查文件是否出错) 

哈希算法将任意长度的二进制值映射为固定长度的较小二进制值，这个小的二进制值称为哈希值。哈希值是一段数据唯一且极其紧凑的数值表示形式。如果散列一段明文而且哪怕只更改该段落的一个字母，随后的哈希都将产生不同的值。要找到散列为同一个值的两个不同的输入，在计算上来说基本上是不可能的。 

##### equals() 和 == ：

**java当中的数据类型和“==”的含义：**

- 基本数据类型（也称原始数据类型） ：byte,short,char,int,long,float,double,boolean。他们之间的比较，应用双等号（==）,比较的是他们的值。
- 引用数据类型：当他们用（==）进行比较的时候，比较的是他们在内存中的存放地址（确切的说，是**堆内存**地址）。

注：对于第二种类型，除非是同一个new出来的对象，他们的比较后的结果为true，否则比较后结果为false。因为每new一次，都会重新开辟堆内存空间。

1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；

　　　　如果作用于引用类型的变量，则比较的是所指向的对象的地址

2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量

　　　　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；

　　　　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。

对于equals，一般我们认为两个对象同类型并且所有属性相等的时候才是相等的，在类中必须改写equals，因为Object类中的equals只是判断两个引用变量是否引用同一对象，如果不是引用同一对象，即使两个对象的内容完全相同，也会返回false。当然，在类中改写这个equals时，你也可以只对部分属性进行比较，只要这些属性相同就认为对象是相等的。

对于hashCode，只要是用在和哈希运算有关的地方，和equals一样，在你的类中也应该改写。当然如果两个对象是完全相同的，那么他们的hashCode当然也是一样的。

正确使用equals方法：

Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals

```java
//不能使用一个值为null的引用类型变量来调用非静态方法，否则抛出异常
String str = null;
if(str.equals("SnailClimb")){
    ...
}else{
    ...
}
//结论：运行后会抛出空指针异常，但是我们把第二行的条件判断语句更改为
"SnailClimb".equals(str);
//推荐使用java.util.Objects#equals（JDK7引入的工具类）
Objects.equals(null,"SnailClimb");
//源码：
    public static boolean equals(Object a, Object b) {
        //可以避免空指针异常，如果a==null的话此时a.equals（b）就不会得到执行，避免出现空指针异常
        return (a == b) || (a != null && a.equals(b));
    }
```

Java中equals方法造成空指针异常的原因以及解决方案有：

1. 每种原始类型都有默认值，如：int默认值为0，boolean的默认值为false，null是任何引用类型的默认值，不严格的说是所有Object类型的默认值.
2. 可以使用==或者!=操作来比较null值，但是不能使用其他算法和逻辑操作。在java中null==null将返回true
3. 不能使用一个值为null的引用类型变量来调用非静态方法，否则抛出异常。

##### 集合:

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110210830330.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

List：有序、可重复。可以通过索引快速查找，但进行增删操作时后续的数据需要移动，所以增删速度慢。

Set：无序、不可重复。

Map: 键值对,键唯一, 值不唯一. Map集合中存储的是键值对,键不能重复, 值可以重复.根据键得到值,对map集合遍历时先得到键的set集合, 对set 集合进行遍历, 得到相应的值.

##### 多线程: ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110211118541.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

新建状态:一个新产生的线程从新状态开始了它的生命周期.它保持这个状态直到程序start这个线程.

运行状态:当一个新状态的线程被start以后,线程就变成了可运行状态,一个线程在此状态下被认为是开始执行其任务.

就绪状态:当一个线程等待另外一个线程执行一个任务的时候,该线程就进入就绪状态. 当另一个线程给就绪状态的线程发送信号时,该线程才重新切换到运行状态.

休眠状态:由于一个线程的时间片用完了,该线程从运行状态进入休眠状态.当时间间隔到期或者等待的时间发生了,该状态的线程切换到运行状态.

终止状态:一个运行状态的线程完成任务或者其他终止条件发生,该线程就切换到终止的状态.

1、什么是 GC？为什么要有 GC？
GC（Garbage Collection）是垃圾收集的意思，负责清除对象并释放内存。Java 提供的 GC 功能可以自动检测对象是否超过作用域从而达到自动回收内存的目的，从而防止内存泄漏。

2、final, finally 和 finalize 的区别？
final 用于声明属性，方法和类，表示属性不可变，方法不可被重写，类不可被继承。

finally 是异常处理语句结构的一部分，表示总是执行。

finalize 是 object 类的一个方法，在垃圾收集器执行的时候会调用这个对象回收的方法，工垃圾收集时其他资源的回收，比如关闭文件。

3、什么是单例模式？实现步骤？
单例模式保证了对象唯一。分为懒汉式（在类加载时不初始化）和饿汉式（在类加载时就完成了初始化，所以类加载比较慢，但获取对象的速度快。

实现步骤：私有化构造函数、创建一个静态的私有对象、提供公共的访问方法。

4、ArrayList 和 LinkedList 有何区别？
ArrayList 是基于动态数组的数据结构，LinkedList 是基于链表的数据结构；对于随机访问 get 和 set，ArrayList 较优，因为 LinkedList 要移动指针；对于新增和删除操作 add 和 remove，LinedList 较优，因为ArrayList 要移动数据。

5、HashMap 和 Hashtable 的区别？
HashMap 允许空键值，Hashtable 不允许；

HashMap 继承自 AbstractMap，Hashtable 继承自 Dictionary 类，两者都实现了 Map 接口； HashMap 的方法不是同步的，Hashtable 的方法是同步的。

6、Iterater 和 ListIterator 之间有什么区别？
Iterator 用来遍历 Set 和 List 集合，而 ListIterator 只能遍历 List； Iterator 只可以向前遍历，而 LIstIterator 可以双向遍历；ListIterator 从 Iterator 接口继承，然后添加了一些额外的功能，比如添加一个元素、替换一个元素、获取前面或后面元素的索引位置。

7、创建线程的方式？
继承 Thread 类

实现 Runnable 接口

使用 Executor 框架

8、什么是死锁？
两个线程或两个以上线程都在等待对方执行完毕才能继续往下执行的时候就发生了死锁。结果就是这些线程都陷入了无限的等待中。

9、wait()与 sleep()的区别？
sleep()来自 Thread 类，wait()来自 Object 类；

调用 sleep()方法，线程不会释放对象锁。而调用 wait 方法线程会释放对象锁；

sleep()睡眠后不出让系统资源，wait让其他线程可以占用 CPU；

sleep(milliseconds)需要指定一个睡眠时间，时间一到会自动唤醒。而wait()需要配合 notify()

或者 notifyAll()使用。

10、什么是 ThreadLocal？ThreadLocal 和 Synchonized 的区别？
线程局部变量。是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java提供 ThreadLocal 类来支持线程局部变量，是一种实现线程安全的方式。

synchronized 是利用锁的机制,使变量或代码块在某一时刻只能被一个线程访问.而ThreadLocal为每一个线程都提供了变量的副本,使得每个线程在某一时间访问到的并不是同一个对象,这样就隔离了多个线程对数据的数据共享.

super()与this()的区别?

This():当前类的对象,super父类对象. Super(): 在子类访问父类的成员和行为,必须接受类继承规则的约束. 而this代表当前对象,当然所有的资源都可以访问. 在构造函数中, 如果第一行没有写super(), 编译器会自动插入,但是如果父类没有不带参数的构造函数,或这个函数被私有化了(用private修饰),此时必须加入对父类的实例化构造,而this就没有这个要求,因为它本身就进行实例化的构造. 而在方法中super 和 this使用的方法就差不多,只不过super要考虑是否能访问其父类资源.

作用域public,protected,private,以及不写时的区别?

Public:不同包、同一包、类内都可用

Private：类内

Protected: 不同包的子类、同一包、类内都可用

不写时:同一包内、类内

Java的事件委托机制和垃圾回收机制:

Java 事件委托机制的概念, 一个源产生一个事件并将它送到一个或多个监听器那里。在这种方案中，监听器简单的等待，直到它收到一个事件。一旦事件被接受，监听器将处理这个事件，然后返回。垃圾回收机制 垃圾收集是将分配给对象但不再使用的内存回收或释放的过程。如果一个对象没有指向它的引用或者其赋值为 nul l , 则次对象适合进行垃圾回收.

什么是 java 序列化，如何实现 java 序列化？(写一个实例) 

序列化: 处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。

序列化的实现：将需要被序列化的类实现 Serializable 接口，该接口没有需要实现的方法，implements Serializable 只是为了标注该对象是可被序列化的，然后使用一个输出流( 如：FileOut put Stream) 来构造一个 Object Output Stream( 对象流) 对象，接着，使用 Object Output Stream对象的 writeObject ( Object obj ) 方法就可以将参数为 obj 的对象写出( 即保存其状态) ，要恢复的话则用输入流。

一个".java"源文件中是否可以包括多个类（不是内部类）？有什么限制？ 

可以.如果这个类的修饰符是public,其类名与文件名必须相同.

排序都有哪几种方法？请列举。用 JAVA 实现一个快速排序？ 

排序的方法有：插入排序（直接插入排序、希尔排序），交换排序（冒泡排序、快速排序），选择排序（直接选择排序、堆排序），归并排序，分配排序（箱排序、基数排序）快速排序的伪代码。 

选择排序:

```java
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }        
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

}
```

Overload 和 Override 的区别。Overloaded 的方法是否可以改变返回值的类型? 

方法的重写 Override，子类覆盖父类的方法，将子类传与父类的引用调用的还是子类的方法。重载 Overloading 一个类多个方法，名称相同，参数个数类型不同。两者都是 Java 多态性的不同表现。Overloaded的方法是可以改变返回值的类.型。

##### 乐观锁:

顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库提供的类似于write_condition机制，其实都是提供的乐观锁。在Java中java.util.concurrent.atomic包下面的原子变量类就是使用了乐观锁的一种实现方式CAS实现的。 

##### 悲观锁:

总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。再比如Java里面的同步原语synchronized关键字的实现也是悲观锁。 

##### 分离锁:

在某些情况下，可以将锁分解技术进一步扩展为对一组独立对象上的锁进行分解，这种情况称为锁分段。例如ConcurrencyHashMap是有一个包含16个锁的数组实现，每个锁保护所有散列桶的1/16，其中第N个散列桶由第（N mod 16）个锁来保护。假设所有关键字都时间均与分布，那么相当于把锁的请求减少到原来的1/16，可以支持多达16个的并发写入。

锁分段的劣势在于：与采用单个锁来实现独占访问相比，要获取多个锁来实现独占访问将更加困难并且开销更高，比如计算size、重hash。

##### CAS:

CAS是乐观锁技术，当多个线程尝试使用CAS同时更新同一个变量时，只有其中一个线程能更新变量的值，而其它线程都失败，失败的线程并不会被挂起，而是被告知这次竞争中失败，并可以再次尝试。　　　

　　　　CAS 操作中包含三个操作数 —— 需要读写的内存位置（V）、进行比较的预期原值（A）和拟写入的新值(B)。如果内存位置V的值与预期原值A相匹配，那么处理器会自动将该位置值更新为新值B。否则处理器不做任何操作。无论哪种情况，它都会在 CAS 指令之前返回该位置的值。（在 CAS 的一些特殊情况下将仅返回 CAS 是否成功，而不提取当前值。）CAS 有效地说明了“ 我认为位置 V 应该包含值 A；如果包含该值，则将 B 放到这个位置；否则，不要更改该位置，只告诉我这个位置现在的值即可。 ”这其实和乐观锁的冲突检查+数据更新的原理是一样的。

A: public 不同包,同一包,类内都可用   private: 类内

#### “volatile” 

#### — 保证读写的都是主内存的变量 “synchronized” — 保证在块开始时都同步主内存的值到工作内存，而块结束时将变量同步回主内存,只有成员变量才能使用它。在Java并发程序缺少同步类的情况下，多线程对成员变量的操作对其它线程是透明的。volatile变量可以保证下一个读取操作会在前一个写操作之后发生。线程都会直接从内存中读取该变量并且不缓存它。这就确保了线程读取到的变量是同内存中是一致的。  

**java虚拟机栈,规定了两种异常状况：**

1. **如果线程请求的深度大于虚拟机所允许的深度，将抛出StackOverflowError异常**。
2. **如果虚拟机栈动态扩展，而扩展时无法申请到足够的内存，就会抛出OutOfMemoryError异常**

### 方法区（Method Area）

**可通过参数-XX:MaxPermSize设置**

1. **线程共享内存区域，用于储存已被虚拟机加载的类信息、常量、静态变量，即编译器编译后的代码，方法区也称持久代（Permanent Generation）**。
2. 虽然Java虚拟机规范把方法区描述为堆的一个逻辑部分，但是它却有一个**别名叫做Non-Heap（非堆）**，目的应该是与Java堆区分开来。
3. 如何实现方法区，属于虚拟机的实现细节，不受虚拟机规范约束。
4. 方法区主要存放java类定义信息，与垃圾回收关系不大，方法区可以选择不实现垃圾回收,但不是没有垃圾回收。
5. **方法区域的内存回收目标主要是针对常量池的回收和对类型的卸载**。
6. **运行时常量池，也是方法区的一部分，虚拟机加载Class后把常量池中的数据放入运行时常量池**。

什么是FutureTask?

FutureTask可用于异步获取执行结果或取消执行任务的场景。通过传入Runnable或者Callable的任务给FutureTask，直接调用其run方法或者放入线程池执行，之后可以在外部通过FutureTask的get方法异步获取执行结果，因此，FutureTask非常适合用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。另外，FutureTask还可以确保即使调用了多次run方法，它都只会执行一次Runnable或者Callable任务，或者通过cancel取消FutureTask的执行等。

**为防止内存溢出，服务器会把长时间内没有活跃的Session从内存删除。这个时间就是Session的超时时间。如果超过了超时时间没访问过服务器，Session就自动失效了。** 

1.在cookie存在情况下我们验证登录需要调用数据库信息吗，怎么匹配信息 

cookie携带sessionID去匹配session的信息，如果超过了会话过期时间，并且已经将session存进了数据库，其就会调用按照姓名查找的方法去数据库中搜寻与之匹配的session并返回session的信息加载进此次会话，如果没有找到就会新建一个session.

2.session是自动写入数据库的吗

是要看具体的设置的，有的网页不需要保存session，就会设置多少分钟之后就会失效，此时是不会写入数据库的。但是如果网页设置了持久化数据，就会将其存进数据库，但是前提是在数据库中创建相对应的表单，表单中有需要存储的数据，然后就可以在跳转之前调用存储的方法将这些内容存进数据库中。

3.session何时被删除

session在下列情况下被删除：
A．程序调用HttpSession.invalidate()
B．距离上一次收到客户端发送的session id时间间隔超过了session的最大有效时间
C．服务器进程被停止

关闭浏览器只会使存储在客户端浏览器内存中的session cookie失效,不会使服务器端的session对象失效,除非此时的Sever端刚好session失效时间到了.

## Collection集合:

![collection](C:\Users\Feiyu\Desktop\collection.gif)

Java 集合框架主要包括两种类型的容器，一种是集合（Collection），存储一个元素集合，另一种是图（Map），存储键/值对映射。Collection 接口又有 3 种子类型，List、Set 和 Queue，再下面是一些抽象类，最后是具体实现类，常用的有 ArrayList、LinkedList、HashSet、LinkedHashSet、HashMap、LinkedHashMap 等等。

集合框架是一个用来代表和操纵集合的统一架构。所有的集合框架都包含如下内容：

- 

  **接口：**是代表集合的抽象数据类型。例如 Collection、List、Set、Map 等。之所以定义多个接口，是为了以不同的方式操作集合对象

- **实现（类）：**是集合接口的具体实现。从本质上讲，它们是可重复使用的数据结构，例如：ArrayList、LinkedList、HashSet、HashMap。

- **算法：**是实现集合接口的对象里的方法执行的一些有用的计算，例如：搜索和排序。这些算法被称为多态，那是因为相同的方法可以在相似的接口上有着不同的实现。

 Set和List的区别

- \1. Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素。
- \2. Set检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变 **<实现类有HashSet,TreeSet>**。
- \3. List和数组类似，可以动态增长，根据实际存储的数据的长度自动增长List的长度。查找元素效率高，插入删除效率低，因为会引起其他元素位置改变 **<实现类有ArrayList,LinkedList,Vector>** 。

## Java Web

Ajax
AJAX = Asynchronous JavaScript and XML（异步 JavaScript 和 XML）。

Ajax 的原理简单来说通过 XmlHttpRequest 对象来向服务器发异步请求，从服务器获得数据，然后用 Javascript 来操作 DOM 而更新页面。这其中最关键的一步就是从服务器获得请求数据。

XmlHttpRequest是ajax的核心机制,它是在IE5中首先引入的,是一种支持异步请求的技术. 就是Javascript可以及时向服务器提出请求和处理响应,而不是阻塞用户.达到无刷新的效果.

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110211740231.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### JQuery

JQuery 是一个 JavaScript 库。功能包括 HTML 元素选取和操作、CSS 操作、HTML 事件函数、 JavaScript 特效和动画、HTML DOM 遍历和修改、AJAX 和 Utilities。除此之外，JQuery 还提供了大量插件。

基础语法： $(selector).action()。

选择器：主要分四大选择器，分别是基本选择器、层次选择器、过滤选择器、属性过滤选择器。

事件：例如 click()、dblclick()、mouseenter()、mouseleave()、mousedown()等。

##### Cookie

在 web 程序中是使用 HTTP 协议来传输数据的，因为 http 是无状态协议，一旦数据交换完毕，客户端和服务器端的连接就会关闭，再次交换数据需要建立新的连接，所以无法实现会话跟踪，cookie 技术则弥补了这一缺陷。

cookie 实际上一段的文本信息，客户端请求服务器。如果服务器需要记录该用户的状态，就使用 response 向客户端浏览器颁发一个 cookie。客户端浏览器会把 cookie 保存起来。当浏览器再请求该网站时，浏览器把请求的网址连同该 cookie 一同提交给服务器。服务器检查该 cookie，以此来辨认用户的状态。服务器还可以根据需要修改 cookie 的内容。
cookie 生命周期:

cookie 的 maxAge 决定 cookie 的生命周期，单位为秒（second）。cookie 通过 getMaxAge() 方法和 setMaxAge()方法来获得 maxAge 属性，如果 maxAhe 属性为正，则表示 cookie 会在 maxAge 秒之后自动失效。如果 maxAge 属性为负，则说明 cookie 仅在本浏览器窗口和本窗口打开的子窗口下有效，关闭窗口 cookie 则失效。maxAge 的默认值是-1 当 maxAge 的值为 0 时，表示删除 cookie。

##### Session

session 也是一种记录客户状态的机制，不同的是 cookie 保存在客户端浏览器中，而 session 保存在服务器上。客户端浏览器访问服务器是时候把客户端信息以某种形式记录在服务器上，这就是 session 中查找该客户的状态。

session 生命周期：

session 保存在服务器端，为了获得更高的存取速度，服务器一般把 session 放在内存。每个用户都会有一个独立的 session,如果 session 内容过于复杂，当大量客户访问服务器时可能会导致内存溢出。

session 在用户第一次访问服务器的时候自动创建，需要注意只有访问 JSP，Servlet 等程序时才会创建 session；只要访问 HTML、IMAGE 等静态资源不会创建 session。如果尚未生成session,可以使用 request.getSession(true)强制生成 session。

session 生成后，只要用户访问，服务器就会更新 session 的最后访问时间，并维护该 session。用户每访问服务器一次，无论是否续写 session 服务器都认为该用户的 session 活跃（active）了一次。

Session对应的类是javax.servlet.http.HttpSession,每个访问者都对应一个session对象,并将其状态信息保存在这个session对象中,session对象的创建是在用户第一次访问服务器产生的.

##### 1、原生态 Ajax 执行流程？

创建 XMLHttpRequest 对象；

注册回调函数；

设置连接信息；

发送数据，与服务器开始交互；

接受服务器返回数据。

##### 2、转发（forward）和重定向（redirect）的区别？

forward 是容器中控制权的转向，是服务器请求资源，服务器直接访问目标地址的 URL，把那个 URL 的响应内容读取过来，然后把这些内容再发给浏览器，浏览器根本不知道服务器发送的内容是从哪儿来的，所以它的地址栏中还是原来的地址。

redirect 就是服务器端根据逻辑，发送一个状态码，告诉浏览器重新去请求那个地址，因此从浏览器的地址栏中可以看到跳转后的链接地址，很明显 redirect 无法访问到服务器保护起来资源，但是可以从一个网站 redirect 到其他网站。

##### 3、怎么防止表单重复提交？

i.禁掉提交按钮。表单提交后使用 Javascript 使提交按钮 disable。

ii．Post/Redirect/Get 模式。在提交后执行页面重定向，这就是所谓的 Post-Redirect-Get (PRG) 模式。简言之，当用户提交了表单后，你去执行一个客户端的重定向，转到提交成功信息页面。

iii.在 session 中存放一个特殊标志。当表单页面被请求时，生成一个特殊的字符标志串，存在 session 中，同时放在表单的隐藏域里。接受处理表单数据时，检查标识字串是否存在，并立即从 session 中删除它，然后正常处理数据。

##### 4、web.xml 文件中可以配置哪些内容？

web.xml用于配置Web应用的相关信息, 如:监听器(listener),过滤器(filter), Servlet, 相关参数,会话超时时间,安全验证方式,错误页面等.



##### 数据库（MySQL）:

连接查询
分类：内连接、外连接、自然连接（略）、交叉连接（略）。

内连接
基本语法：左表 [inner] join 右表 on 左表.字段 = 右表.字段;

从左表中取出每一条记录，去右表中与所有的记录进行匹配：匹配必须是某个条件在左表中与右表中相同最终才会保留结果，否则不保留。

外连接
基本语法: 左表 left/right join 右表 on 左表.字段 = 右表.字段;

left join: 左外连接(左连接), 以左表为主表

right join: 右外连接(右连接), 以右表为主表

以某张表为主，取出里面的所有记录，然后每条与另外一张表进行连接：不管能不能匹配上条件，最终都会保留。能匹配，正确保留；不能匹配，其他表的字段都置空 NULL。

---------------------
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110212746818.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

左外连接

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110212812452.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

右外连接:

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110212836876.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### 联合查询:

基本语法:

​		Select 语句 1 Union [union 选项] Select 语句 2 …… 

将多次查询(多条 select 语句), 在记录上进行拼接(字段不会增加)，每一条 select 语句获取的字段数必须严格一致(但是字段类型无关)。

其中 union 选项有 2 个。ALL：保留所有；Distinct（默认）：去重。

应用：查询同一张表，但是有不同的需求；查询多张表，多张表的结构完全一致，保存的数据也是一样的。

在联合查询中，order by 不能直接使用。需要对查询语句使用括号才行。另外需要配合 limit 使用。

索引
如果说数据库表中的数据是一本书，那么索引就是书的目录。索引能够让我们快速的定位想要查询的数据。

索引的结构：BTree 索引和 Hash 索引。

MyISAM 和 InnoDB 存储引擎：只支持 BTREE 索引， 也就是说默认使用 BTREE，不能够更换。

MEMORY/HEAP 存储引擎：支持 HASH 和 BTREE 索引。

索引的分类：单列索引(普通索引，唯一索引，主键索引)、组合索引、全文索引、空间索引。

数据库引擎
InnoDB：支持事务处理，支持外键，支持崩溃修复能力和并发控制。如果需要对事务的完整

性要求比较高（比如银行），要求实现并发控制（比如售票），那选择 InnoDB 有很大的优势。

如果需要频繁的更新、删除操作的数据库，也可以选择 InnoDB，因为支持事务的提交（commit）

和回滚（rollback）。

MyISAM：插入数据快，空间和内存使用比较低。如果表主要是用于插入新记录和读出记录，

那么选择 MyISAM 能实现处理高效率。如果应用的完整性、并发性要求比较低，也可以使

用。

MEMORY：所有的数据都在内存中，数据的处理速度快，但是安全性不高。如果需要很快的

读写速度，对数据的安全性要求较低，可以选择 MEMOEY。它对表的大小有要求，不能建

立太大的表。所以，这类数据库只使用在相对较小的数据库表。

存储过程
SQL 语句需要先编译然后执行，而存储过程（Stored Procedure）是一组为了完成特定功能的 SQL 语句集，经编译后存储在数据库中，用户通过指定存储过程的名字并给定参数（如果该存储过程带有参数）来调用执行它。

存储过程是可编程的函数，在数据库中创建并保存，可以由 SQL 语句和控制结构组成。当想要在不同的应用程序或平台上执行相同的函数，或者封装特定功能时，存储过程是非常有用的。数据库中的存储过程可以看做是对编程中面向对象方法的模拟，它允许控制数据的访问方式。

存储过程的优点：
增强 SQL 语言的功能和灵活性；
标准组件式编程；
较快的执行速度；
减少网络流量；

1、JDBC 编程的步骤？
（1）	注册驱动；

（2）	获取连接对象 Connection；

（3）	创建 Statement 对象；

（4）	运行 SQL 语句；

（5）	处理结果；

（6）	关闭连接释放资源。

2、事务的 ACID 是什么？事务并发会产生哪些问题？
ACID 表示事务的特性：原子性、一致性、隔离性和持久性。

原子性(Atomic)：事务中各项操作，要么全做要么全不做，任何一项操作的失败都会导致整个事务的失败；

一致性(Consistent)：事务结束后系统状态是一致的；

隔离性(Isolated)：并发执行的事务彼此无法看到对方的中间状态；

持久性(Durable)：事务完成后所做的改动都会被持久化，即使发生灾难性的失败。通过日志和同步备份可以在故障发生后重建数据。

事务并发产生的问题：脏读、幻读、不可重复读。

脏读（Dirty Read）：A 事务读取 B 事务尚未提交的数据并在此基础上操作，而 B 事务执行回滚，那么 A 读取到的数据就是脏数据。

幻读（Phantom Read）：事务 A 重新执行一个查询，返回一系列符合查询条件的行，发现其中插入了被事务 B 提交的行。

不可重复读（Unrepeatable Read）：事务 A 重新读取前面读取过的数据，发现该数据已经被另一个已提交的事务 B 修改过了。

3、数据库性能优化有哪些方式？
SQL 优化：
		尽量避免使用 SELECT	*；
		只查询一条记录时使用 limit 1；
		使用连接查询代替子查询；
		尽量使用一些能通过索引查询的关键字。
表结构优化：

		尽量使用数字类型字段，提高比对效率；
		长度不变且对查询速度要求高的数据可以考虑使用 char，否则使用 varchar；表中字段过多时可以适当的进行垂直分割，将部分字段移动到另外一张表；表中数据量过大可以适当的进行水平分割，将部分数据移动到另外一张表。

其它优化：

		对查询频率高的字段适当的建立索引，提高效率；根据表的用途使用合适的数据库引擎；读写分离。	
框架部分
Spring
Spring 的理解
spring 是一个开源框架，Spring 为简化企业级应用开发而生，使用 Spring 可以使简单的 JavaBean 实现以前只有 EJB 才能实现的功能。Spring 是一个 IOC 和 AOP 容器框架。 Spring 主要核心是：

(1)控制反转(IOC)：传统的 java 开发模式中，当需要一个对象时，我们会自己创建一个对象，而在 Spring 开发模式中，Spring 容器使用了工厂模式为我们创建了所需要的对象，我们直接调用 Spring 为我们提供的对象即可，这就是控制反转的思想。实例化一个 java 对象有三种方式：使用类构造器，使用静态工厂方法，使用实例工厂方法。当使用 spring 时我们不需要关心通过何种方式实例化一个对象，spring 通过控制反转机制自动为我们实例化一个对象。

(2)依赖注入(DI)：Spring 使用 Java Bean 对象的 Set 方法或者带参数的构造方法为我们在创建所需对象时将其属性自动设置所需要的值的过程就是依赖注入的基本思想。

(3)面向切面编程(AOP)：在面向对象编程(OOP)思想中，我们将事物纵向抽象成一个个的对象。而在面向切面编程中，我们将一个个对象某些类似的方面横向抽象成一个切面，对这个切面进行一些如权限验证，事物管理，记录日志等公用操作处理的过程就是面向切面编程的思想。

在 Spring 中，所有管理的对象都是 JavaBean 对象，而 BeanFactory 和 ApplicationContext 就是 spring 框架的两个 IOC 容器，现在一般使用 ApplicationContext，其不但包含了 BeanFactory 的作用，同时还进行更多的扩展。

Spring Bean 生命周期
1.Spring 容器 从 XML 文件中读取 Bean 的定义，并实例化 Bean。

2.Spring 根据 Bean 的定义填充所有的属性。

3.如果 Bean 实现了 BeanNameAware 接口，Spring 传递 bean 的 ID 到 setBeanName 方法。

4.如果 Bean 实现了 BeanFactoryAware 接口， Spring 传递 beanfactory 给 setBeanFactory 方法。

5.如 果 有 任 何 与 bean 相 关 联 的 BeanPostProcessors ， Spring 会 在postProcesserBeforeInitialization()方法内调用它们。

6.如果 bean 实现 IntializingBean 了，调用它的 afterPropertySet 方法，如果 bean 声明了初始化方法，调用此初始化方法。

7.如果有 BeanPostProcessors 和 bean 关联，这些 bean 的 postProcessAfterInitialization() 方法将被调用。

8.如果 bean 实现了 DisposableBean，它将调用 destroy()方法。注意：有两个重要的 bean 生命周期方法，第一个是 setup() ， 它是在容器加载 bean 的时候被调用。第二个方法是 teardown() 它是在容器卸载类的时候被调用。The bean 标签有两个重要的属性 init-method 和 destroy-method。使用它们你可以自己定制初始化和注销方法。它们也有相应的注解@PostConstruct 和@PreDestroy。

Spring 中的设计模式
代理模式—Spring 中两种代理方式，若目标对象实现了若干接口，spring 使用 JDK 的 java.lang.reflect.Proxy 类代理，若目标对象没有实现任何接口，spring 使用 CGLIB 库生成目标对象的子类。

单例模式—在 spring 配置文件中定义的 bean 默认为单例模式。

模板方法模式—用来解决代码重复的问题。比如： RestTemplate, JmsTemplate, JpaTemplate。

前端控制器模式—Srping 提供了 DispatcherServlet 来对请求进行分发。

视图帮助(View Helper )—Spring 提供了一系列的 JSP 标签，高效宏来辅助将分散的代码整合在视图里。

依赖注入—贯穿于 BeanFactory/ApplicationContext 接口的核心理念。

工厂模式—在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。Spring 中使用 BeanFactory 用来创建对象的实例。

Spring 注解
Spring 在 2.5 版本以后开始支持用注解的方式来配置依赖注入。可以用注解的方式来替代 XML 方式的 bean 描述，可以将 bean 描述转移到组件类的内部，只需要在相关类上、方法上或者字段声明上使用注解即可。注解注入将会被容器在 XML 注入之前被处理，所以后者会覆盖掉前者对于同一个属性的处理结果。

注解装配在Spring中是默认关闭的.所以需要在Spring文件中配置一下才能使用基于注解的装配模式.

<beans> <context:annotation-config/> <!-- bean definitions go here --> </beans> 

在 context:annotation-config/标签配置完成以后，就可以用注解的方式在 Spring 中向属

性、方法和构造方法中自动装配变量。

几种比较重要的注解类型：

1.@Required：该注解应用于设值方法。

2.@Autowired：该注解应用于有值设值方法、非设值方法、构造方法和变量。

3.@Qualifier：该注解和@Autowired 注解搭配使用，用于消除特定 bean 自动装配的歧义。

4.JSR-250 Annotations： Spring 支持基于 JSR-250 注解的以下注解，@Resource、 @PostConstruct 和 @PreDestroy。

Spring 事务
Spring 支持两种类型的事务管理：

1.编程式事务管理：这意味你通过编程的方式管理事务，给你带来极大的灵活性，但是难维护。

2.声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和 XML 配置来管理事务。

```xml
<!-- 定义事务管理器（声明式的事务） -->

<bean id="transactionManager"

class="org.springframework.orm.hibernate3.HibernateTransactionManager">

<property name="sessionFactory" ref="sessionFactory" />

</bean>

<!-- 配置 Advice 通知 -->

<tx:advice id="txAdvice" transaction-manager="transactionManager"> <tx:attributes>

<tx:method name="*" propagation="REQUIRED" /> </tx:attributes>

</tx:advice>

<!-- 配置切点切面 -->

<aop:config>

<aop:pointcut id="interceptorPointCuts" expression="execution(* com.bluesky.spring.dao.*.*(..))" />

<aop:advisor advice-ref="txAdvice"

pointcut-ref="interceptorPointCuts" />

</aop:config>
```

## SpringMVC

##### SpringMVC 执行流程

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110214322824.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

1、用户发送请求至 DispatcherServlet（前端控制器）；

2、DispatcherServlet 收到请求调用 HandlerMapping（处理器映射器）；

3、HandlerMapping 找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给 DispatcherServlet；

4、DispatcherServlet 调用 HandlerAdapter（处理器适配器）；

5、HandlerAdapter 经过适配调用具体的 Controller (处理器，也叫后端控制器)；

6、Controller 执行完成返回 ModelAndView 对象；

7、HandlerAdapter 将 controller 执行结果 ModelAndView 返回给 DispatcherServlet；

8、DispatcherServlet 将 ModelAndView 传给 ViewReslover（视图解析器）；

9、ViewReslover 解析后返回具体 View；

10、DispatcherServlet 根据 View 进行渲染视图（即将模型数据填充至视图中）；

11. DispatcherServlet响应用户;

springmvc 常用注解
@RequestMapping：是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。

@PathVariable：用于将请求 URL 中的模板变量映射到功能处理方法的参数上，即取出 uri 模板中的变量作为参数。

@requestParam ： 主 要 用 于 在 SpringMVC 后 台 控 制 层 获 取 参 数 ， 类 似 一 种 是request.getParameter(“name”)，它有三个常用参数：defaultValue = “0”, required = false, value = “isApp”；defaultValue 表示设置默认值，required 铜过 boolean 设置是否是必须要传入的参数，value 值表示接受的传入的参数类型。

@ResponseBody ： 该 注 解 用 于 将	Controller	的 方 法 返 回 的 对 象 ， 通 过 适 当 的HttpMessageConverter 转换为指定格式后，写入到 Response 对象的 body 数据区。使用时机：返回的数据不是 html 标签的页面，而是其他某种格式的数据时（如 json、xml 等）使用 @RequestBody ： 该 注 解 常 用 来 处 理 Content-Type: 不 是 application/x-www-form-urlencoded 编码的内容，例如 application/json, application/xml 等； @RequestHeader ：可以把 Request 请求 header 部分的值绑定到方法的参数上。

@CookieValue ：可以把 Request header 中关于 cookie 的值绑定到方法的参数上。

SpringMVC 和 Struts2 对比
机制：spring mvc 的入口是 servlet，而 struts2 是 filter（这里要指出，filter 和 servlet 是不同的。以前认为 filter 是 servlet 的一种特殊），这样就导致了二者的机制不同，这里就牵涉到 servlet 和 filter 的区别了。

性能：spring 会稍微比 struts 快。spring mvc 是基于方法的设计，而 sturts 是基于类，每次发一次请求都会实例一个 action，每个 action 都会被注入属性，而 spring 基于方法，粒度更细，但要小心把握像在 servlet 控制数据一样。spring3 mvc 是方法级别的拦截，拦截到方法后根据参数上的注解，把 request 数据注入进去，在 spring3 mvc 中，一个方法对应一个 request 上下文。而 struts2 框架是类级别的拦截，每次来了请求就创建一个 Action，然后调用 setter getter 方法把 request 中的数据注入；struts2 实际上是通过 setter getter 方法与 request 打交道的；struts2 中，一个 Action 对象对应一个 request 上下文。

参数传递：struts 是在接受参数的时候，可以用属性来接受参数，这就说明参数是让多个方法共享的。

设计思想上: struts更加符合oop的编程思想,spring就比较谨慎,在servlet上扩展.

##### Mybatis

Mybatis 的理解
MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。MyBatis 避免了几乎所有的 JDBC 代码和手工设置参数以及抽取结果集。MyBatis 使用简单的 XML 或注解来配置和映射基本体，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java 对象)映射成数据库中的记录。

Mybatis 的优点：

1、简单易学。mybatis 本身就很小且简单。没有任何第三方依赖，最简单安装只要两个 jar 加配置几个 sql 映射文件，易于学习，易于使用，通过文档和源代码，可以比较完全的掌握它的设计思路和实现；

2、灵活。mybatis 不会对应用程序或者数据库的现有设计强加任何影响。 sql 写在 xml 里，便于统一管理和优化。通过 sql 基本上实现不使用数据访问框架可以实现的所有功能；

3、解除 sql 与程序代码的耦合。通过提供 DAO 层，将业务逻辑和数据访问逻辑分离，使系统的设计更清晰，更易维护，更易单元测试。sql 和代码的分离，提高了可维护性；4、提供映射标签，支持对象与数据库的 orm 字段关系映射；5、提供对象关系映射标签，支持对象关系组建维护；

6、提供 xml 标签，支持编写动态 sql。

Mybatis 缓存
一级缓存：Mybatis 的一级缓存的作用域是 session，当 openSession()后，如果执行相同的SQL（相同语句和参数），Mybatis 不进行执行 SQL，而是从缓存中命中返回。

二级缓存: Mybatis的二级缓存的作用域是一个mapper的namespace,同一个namespace中查询sql可以从缓存中命中.二级缓存是可以跨session的.

MyBatis的主要的核心部件有以下几个： 

SqlSession：作为MyBatis工作的主要顶层API，表示和数据库交互的会话，完成必要数据库增删改查功能；

Executor：MyBatis执行器，是MyBatis 调度的核心，负责SQL语句的生成和查询缓存的维护；

StatementHandler：封装了JDBC Statement操作，负责对JDBC statement 的操作，如设置参数、将Statement结果集转换成List集合。

ParameterHandler：负责对用户传递的参数转换成JDBC Statement 所需要的参数；

ResultSetHandler：负责将JDBC返回的ResultSet结果集对象转换成List类型的集合；

TypeHandler：负责java数据类型和jdbc数据类型之间的映射和转换；

MappedStatement：MappedStatement维护了一条<select|update|delete|insert>节点的封装；

SqlSource：负责根据用户传递的parameterObject，动态地生成SQL语句，将信息封装到BoundSql对象中，并返回；

BoundSql：表示动态生成的SQL语句以及相应的参数信息；

Configuration: Mybatis所有的配置信息都维持在Configuration对象中；

##### SpringBoot

##### SpringBoot 简介

Spring Boot(英文中是“引导”的意思)，是用来简化 Spring 应用的搭建到开发的过程。应用开箱即用，只要通过 “just run”（可能是 java -jar 或 tomcat 或 maven 插件 run 或 shell 脚本），就可以启动项目。二者，Spring Boot 只要很少的 Spring 配置文件（例如那些 xml，property）。因为“习惯优先于配置”的原则，使得 Spring Boot 在快速开发应用和微服务架构实践中得到广泛应用。

SpringBoot 特性
自动配置：针对很多 Spring 应用程序常见的应用功能，Spring Boot 能自动提供相关配置；起步依赖：告诉 Spring Boot 需要什么功能，它就能引入需要的库；

命令行界面：这是 Spring Boot 的可选特性，借此你只需写代码就能完成完整的应用程序，无需传统项目构建；

Actuator：让你能够深入运行中的 Spring Boot 应用程序，一探究竟。

SpringBoot 核心
@SpringBootApplication 这个 Spring Boot 核心注解是由其它三个重要的注解组合，分别是：

@SpringBootConfiguration 、 @EnableAutoConfiguration 和 @ComponentScan。

@ SpringBootConfiguration

点开查看发现里面还是应用了@Configuration。任何一个标注了@Configuration 的 Java 类定义的都是一个 JavaConfig 配置类。SpringBoot 社区推荐使用基于 JavaConfig 的配置形式，所以，这里的启动类标注了@Configuration 之后，本身其实也是一个 IoC 容器的配置类。

@EnableAutoConfiguration

是一个复合注解。最重要的是@Import(EnableAutoConfigurationImportSelector.class)，借助EnableAutoConfigurationImportSelector，@EnableAutoConfiguration 可以帮助 SpringBoot 应用将所有符合条件的@Configuration 配置都加载到当前 SpringBoot 使用的 IoC 容器。 

@ComponentScan

@ComponentScan这个注解,它对应XML配置中的元素, 功能是自动扫描并加载符合条件的组件(比如@component和@Repository等) 或者bean定义, 最终将这些bean定义加载到IOC容器中.

I. Bean的存在与否作为条件

当Bean不存在时，创建一个默认的Bean，在Spring的生态中可以说比较常见了；接下来看下这种方式可以怎么用

1. `@ConditionalOnBean`

要求bean存在时，才会创建这个bean；如我提供了一个bean名为`RedisOperBean`，用于封装redis相关的操作；但是我这个bean需要依赖`restTemplate`这个bean，只有当应用引入了redis的相关依赖，并存在`RestTemplate`这个bean的时候，我这个bean才会生效

假设bean的定义如下

```java
@Component
@ConditionalOnBean(name="redisTemplate")
public class RedisOperBean {
  private final RedisTemplate redisTemplate;
  public RedisOperBean(RedisTemplate redisTemplate) {
      // ...
  }
}
```

这样的好处就是我提供的这个第三方包，如果被用户A间接依赖（但是A本身不需要操作redis），也不会因为创建`RedisOperBean`而抛异常

> 产生异常的原因是因为找不到RestTemplate的bean，因此无法实例化RedisOperBean，从而抛出异常

2. `@ConditionalOnMissingClass`

class不存在时，才会加载bean



##### SpringCloud

SpringCloud 简介
spring Cloud 是一个基于 Spring Boot 实现的云应用开发工具，它为基于 JVM 的云应用开发中的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等操作提供了一种简单的开发方式。

SpringCloud 核心组件
服务注册发现 - Netflix Eureka

配置中心 - spring cloud config

负载均衡-Netflix Ribbon

断路器 - Netflix Hystrix

路由(网关) - Netflix Zuul

![img](https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=835037166,3207950096&fm=173&app=49&f=JPEG?w=640&h=532&s=D8AA3C72510A674D14611C460000E0B1) 

Ribbon:

![img](https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1440756994,300152436&fm=173&app=49&f=JPEG?w=640&h=404&s=8952E516175A55CA064CF1DE0300F0B2) 

作用：Ribbon，主要提供客户侧的软件负载均衡算法。

简介：Spring Cloud Ribbon是一个基于HTTP和TCP的客户端负载均衡工具，它基于Netflix Ribbon实现。通过Spring Cloud的封装，可以让我们轻松地将面向服务的REST模版请求自动转换成客户端负载均衡的服务调用。

注意看上图，关键点就是将外界的rest调用，根据负载均衡策略转换为微服务调用。Ribbon有比较多的负载均衡策略。

Hystrix:

![img](https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1777007757,3850477758&fm=173&app=49&f=JPEG?w=561&h=535&s=88227E32D532578A0A4D18D80200F0B0) 

作用：断路器，保护系统，控制故障范围。

简介：为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。

```
Hystrix整个工作流如下：

1.构造一个 HystrixCommand或HystrixObservableCommand对象，用于封装请求，并在构造方法配置请求被执行需要的参数；
2.执行命令，Hystrix提供了4种执行命令的方法，后面详述；
3.判断是否使用缓存响应请求，若启用了缓存，且缓存可用，直接使用缓存响应请求。Hystrix支持请求缓存，但需要用户自定义启动；
4.判断熔断器是否打开，如果打开，跳到第8步；
5.判断线程池/队列/信号量是否已满，已满则跳到第8步；
6.执行HystrixObservableCommand.construct()或HystrixCommand.run()，如果执行失败或者超时，跳到第8步；否则，跳到第9步；
7.统计熔断器监控指标；
8.走Fallback备用逻辑
9.返回请求响应
```

Hystrix提供了两种线程隔离方式：线程池和信号量。 Hystrix通过命令模式对发送请求的对象和执行请求的对象进行解耦，将不同类型的业务请求封装为对应的命令请求。 

### **熔断器配置**

Circuit Breaker主要包括如下6个参数：

1、circuitBreaker.enabled

是否启用熔断器，默认是TRUE。
2 、circuitBreaker.forceOpen

熔断器强制打开，始终保持打开状态，不关注熔断开关的实际状态。默认值FLASE。
3、circuitBreaker.forceClosed

熔断器强制关闭，始终保持关闭状态，不关注熔断开关的实际状态。默认值FLASE。

4、circuitBreaker.errorThresholdPercentage
错误率，默认值50%，例如一段时间（10s）内有100个请求，其中有54个超时或者异常，那么这段时间内的错误率是54%，大于了默认值50%，这种情况下会触发熔断器打开。

5、circuitBreaker.requestVolumeThreshold

默认值20。含义是一段时间内至少有20个请求才进行errorThresholdPercentage计算。比如一段时间了有19个请求，且这些请求全部失败了，错误率是100%，但熔断器不会打开，总请求数不满足20。

6、circuitBreaker.sleepWindowInMilliseconds

半开状态试探睡眠时间，默认值5000ms。如：当熔断器开启5000ms之后，会尝试放过去一部分流量进行试探，确定依赖服务是否恢复。

Zuul:

 ![img](https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4174549873,3621025584&fm=173&app=49&f=JPEG?w=640&h=356&s=19843C7A95634509507C54DF0000C0B3) 

作用：api网关，路由，负载均衡等多种作用

简介：类似nginx，反向代理的功能，不过netflix自己增加了一些配合其他组件的特性。

在微服务架构中，后端服务往往不直接开放给调用端，而是通过一个API网关根据请求的url，路由到相应的服务。当添加API网关后，在第三方调用端和服务提供方之间就创建了一面墙，这面墙直接与调用方通信进行权限控制，后将请求均衡分发给后台服务端。

Config:

 ![img](https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1024635647,2230865972&fm=173&app=49&f=JPEG?w=640&h=540&s=29A777324D0B454F104CC0D80000D0B2) 

作用：配置管理

简介：SpringCloud Config提供服务器端和客户端。服务器存储后端的默认实现使用git，因此它轻松支持标签版本的配置环境，以及可以访问用于管理内容的各种工具。

这个还是静态的，得配合Spring Cloud Bus实现动态的配置更新。

##### 微服务:

微服务是一种让软件职责单一,松耦合,自包含,可以独立运行和部署的架构思想. 关键思想就是:拆分,单一,独立,组件化.把原本一个庞大的复杂的项目按业务边界拆分一个一个独立运行的小项目,通过接口的方式组装成大项目.

##### Docker:

Docker 项目的目标是实现轻量级的操作系统虚拟化解决方案。 Docker 的基础是 Linux 容器（LXC）等技术。在 LXC 的基础上 Docker 进行了进一步的封装，让用户不需要去关心容器的管理，使得操作更为简便。用户操作 Docker 的容器就像操作一个快速轻量级的虚拟机一样简单。

Docker 理解
Docker 其实和虚拟机的目的差不多，都是虚拟化技术，但是 docker 比虚拟机更加轻量级，更快，更加易于移植。

镜像: 创建虚拟机和 docker 都必不可少的东西。创建一个虚拟机，就先得下载操作系统的 ISO 镜像文件，然后通过镜像文件安装操作系统，和实体机类似，然后能在虚拟机中去安装各种软件。

容器: 通俗拿VM虚拟机和Docker来举例,一个容器就类似于一个虚拟机,只不过在Docker技术的术语上称为容器.这个容器里装的就是我们部署的应用在运行,和虚拟机一样可以开机,关机,重启. Docker称为容器的运行,关闭,重启.而且这个容器可以打包为镜像文件,类似虚拟机快照的文件,放在其他虚拟机上又可以保持原样能运行, Docker也是,把容器打包为镜像文件,然后在新的服务器安装好的Docker环境下导入进去,保持原来的状态能够运行.

##### Redis:

Redis 简介
Remote Dictionary Server（Redis）是一个基于 key-value 键值对的持久化数据库存储系统。支持多种数据结构，这些数据类型都支持 push/pop、add/remove 及取交集并集和差集及更丰富的操作，而且这些操作都是原子性的。

缓存是走内存的，内存天然就支撑高并发。 用缓存，主要有两个用途：**高性能**、**高并发**。 

最经典的缓存+数据库读写的模式，就是 Cache Aside Pattern。

- 读的时候，先读缓存，缓存没有的话，就读数据库，然后取出数据后放入缓存，同时返回响应。
- 更新的时候，**先更新数据库，然后再删除缓存**。

**为什么是删除缓存，而不是更新缓存？**

原因很简单，很多时候，在复杂点的缓存场景，缓存不单单是数据库中直接取出来的值。



Redis 支持的数据类型
字符串（strings）
散列（hashes）
列表（lists）
集合（sets）
有序集合（sorted sets）

Redis 应用场景
缓存
计数器
发布订阅构建消息系统
排行榜

Redis 持久化
RDB 持久化可以在指定的时间间隔内生成数据集的时间点快照（point-in-time snapshot）。 AOF 持久化记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集。 AOF 文件中的命令全部以 Redis 协议的格式来保存，新命令会被追加到文件的末尾。 Redis 还可以在后台对 AOF 文件进行重写（rewrite），使得 AOF 文件的体积不会超出保存数据集状态所需的实际大小。

Redis 的优势
性能极高 – Redis 能读的速度是 110000 次/s,写的速度是 81000 次/s 。

丰富的数据类型 – Redis 支持二进制案例的 Strings, Lists, Hashes, Sets 及 Ordered Sets 数据类型操作。

原子-Redis的所有操作都是原子性的,意思就是要么成功要么失败完全不执行.单个操作是原子性的.多个操作也支持事务,即原子性,通过MULTI和EXEC指令包起来.丰富的特性-Redis还支持publish/subscribe,通知,key过期等特性.

##### Solr:

Solr 简介
Solr 是一个基于 Lucene 的 Java 搜索引擎服务器。Solr 提供了层面搜索、命中醒目显示并且支持多种输出格式（包括 XML/XSLT 和 JSON 格式）。它易于安装和配置，而且附带了一个基于 HTTP 的管理界面。Solr 已经在众多大型的网站中使用，较为成熟和稳定。Solr 包装并扩展了 Lucene，所以 Solr 的基本上沿用了 Lucene 的相关术语。更重要的是，Solr 创建的索引与 Lucene 搜索引擎库完全兼容。通过对 Solr 进行适当的配置，某些情况下可能需要进行编码，Solr 可以阅读和使用构建到其他 Lucene 应用程序中的索引。此外，很多 Lucene 工具（如 Nutch、 Luke）也可以使用 Solr 创建的索引。

Solr 配置
Schema.xml：

在下载 solr 包的安装解压目录的\solr\example\solr\collection1\conf 中找到，它就是 solr 模式关联的文件。

fieldtype 节点主要用来定义数据类型；

field 节点指定建立索引和查询数据的字段；

solrQueryParser 指定搜索时多个词之间的关系，可以是 or 或 and。

solrconfig.xml：

配置文件主要定义了 SOLR 的一些处理规则，包括索引数据的存放位置，更新，删除，查询的一些规则配置。

datadir 节点定义了索引数据和日志文件的存放位置； lib 节点表示 solr 引用包的位置。

倒排索引

正排表(索引)是以文档的ID为关键字,表中记录文档中每个字的位置信息,查找时扫描表中每个文档中字的信息直到找出所有包含查询关键字的文档.

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110215409167.png) 

倒排表（索引）以字或词为关键字进行索引，表中关键字所对应的记录表项记录了出现这个字或词的所有文档，一个表项就是一个字表段，它记录该文档的 ID 和字符在该文档中出现的位置情况。 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110215447765.png) 

## RabbitMQ/ActiveMQ

RabbitMQ 简介
RabbitMQ 是一个由 Erlang 语言开发的 AMQP 的开源实现。

AMQP：Advanced Message Queue，高级消息队列协议。它是应用层协议的一个开放标准，为面向消息的中间件设计，基于此协议的客户端与消息中间件可传递消息，并不受产品、开发语言等条件的限制。

RabbitMQ 特点
可靠性（Reliability）： 使用持久化、传输确认和发布确认机制来保证可靠性。

灵活的路由（Flexible Routing）：在消息进入队列之前，通过 Exchange 来路由消息的。对于典型的路由功能，RabbitMQ 已经提供了一些内置的 Exchange 来实现。针对更复杂的路由功能，可以将多个 Exchange 绑定在一起，也通过插件机制实现自己的 Exchange 。

高可用（Highly Available Queues）：队列可以在集群中的机器上进行镜像，使得在部分节点出问题的情况下队列仍然可用。

多种协议（Multi-protocol）：RabbitMQ 支持多种消息队列协议，比如 STOMP、MQTT 等。多语言客户端（Many Clients）：RabbitMQ 几乎支持所有常用语言，比如 Java、.NET、Ruby等。

管理界面（Management UI）：RabbitMQ 提供了一个易用的用户界面，使得用户可以监控和管理消息 Broker 的许多方面。

跟踪机制（Tracing）：如果消息异常，RabbitMQ 提供了消息跟踪机制，使用者可以找出发生了什么。

插件机制（Plugin System）：RabbitMQ 提供了许多插件，来从多方面进行扩展，也可以编写自己的插件。

RabbitMQ 工作模式
简单模式：一个生产者发送消息到队列，一个消费者接收。

工作队列模式：一个生产者，多个消费者，每个消费者获取到的消息唯一，多个消费者只有一个队列。

发布/订阅模式：一个生产者发送的消息会被多个消费者获取，每个消费者只能从自己订阅的队列中获取。

路由模式：生产者发布消息的时候添加路由键，消费者绑定队列到交换机时添加键值，这样就可以接收到需要接收的消息。

通配符模式：基本思想和路由模式是一样的，只不过路由键支持模糊匹配，符号“#”匹配一个或多个词，符号“*”只匹配一个词。

ActiveMQ 简介
ActiveMQ 是 Apache 推出的一款开源的，完全支持 JMS1.1 和 J2EE1.4 规范的 JMS Provider 实现的消息中间件。

ActiveMQ 工作模式
点对点模式：一个消息只有一个消费者消费。

发布/订阅模式：订阅一个主题的消费者只能消费自它订阅之后发布的消息。JMS 规范允许客户创建持久订阅，这在一定程度上放松了时间上的相关性要求。持久订阅允许消费者消费它在未处于激活状态时发送的消息。

MQ对比:

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110215702870.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### Dubbo:

Dubbo 简介
Dubbo 是一个分布式服务框架，致力于提供高性能和透明化的 RPC 远程服务调用方案，以及 SOA 服务治理方案。

其核心部分包括：

远程通讯：提供对多种基于长连接的 NIO 框架抽象封装，包括多种线程模型、序列化、"请求-响应"模式的信息交换方案；

集群容错：提供基于借口方法的透明远程过程调用，包括多协议支持、软负载均衡、失败容错、地址路由、动态配置等集群支持；

自动发现：基于注册中心目录服务，使服务消费方能动态地查找服务提供方，使地址透明，使服务提供方可以平滑增加或减少机器。

Dubbo 开发流程
第一步：要在系统中使用 dubbo 应该先搭建一个注册中心，一般推荐使用 zookeeper；第二步：有了注册中心然后是发布服务，发布服务需要使用 spring 容器和 dubbo 标签来发布服务。并且发布服务时需要指定注册中心的位置；

第三步：服务发布之后就是调用服务。一般调用服务也是使用 spring 容器和 dubbo 标签来引用服务，这样就可以在客户端的容器中生成一个服务的代理对象，在 action 或者 Controller 中直接调用 service 的方法即可。

Zookeeper注册中心的作用主要就是注册和发现服务的作用.类似于房产中介的作用,在系统中并不参与与服务的调用及数据的传输.

##### FastDFS:

FastDFS 简介
FastDFS 是一个开源的高性能分布式文件系统（DFS）。 它的主要功能包括：文件存储，文件同步和文件访问，以及高容量和负载平衡。主要解决了海量数据存储问题，特别适合以中小文件（建议范围：4KB < file_size <500MB）为载体的在线服务。

FastDFS 系统有三个角色：跟踪服务器(Tracker Server)、存储服务器(Storage Server)和客户端(Client)。

Tracker Server：跟踪服务器，主要做调度工作，起到均衡的作用；负责管理所有的 storage server 和 group，每个 storage 在启动后会连接 Tracker，告知自己所属 group 等信息，并保持周期性心跳。

Storage Server：存储服务器，主要提供容量和备份服务；以 group 为单位，每个 group 内

可以有多台 storage server，数据互为备份。

Client: 客户端,上传下载数据的服务器,也就是自己项目所部署在的服务器.

​	![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110215951129.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### Nginx:

Nginx 功能
静态 HTTP 服务器：Nginx 是一个 HTTP 服务器，可以将服务器上的静态文件（如 HTML、图片）通过 HTTP 协议展现给客户端。

反向代理服务器：客户端本来可以直接通过 HTTP 协议访问某网站应用服务器，但如果单台服务器承受不住压力需要使用多台服务器共同处理请求，这时可以在中间加上一个 Nginx，客户端请求 Nginx，Nginx 请求应用服务器，然后将结果返回给客户端，此时 Nginx 就是反向代理服务器。

负载均衡:当客户端访问量很大,通过反向代理的方式,使用轮询,加权轮询和IP Hash的策略将请求分配给堕胎服务器.

##### Quartz:

Quartz 简介
Quartz 是一个任务调度框架。它具有以下特点：

强大的调度功能，例如支持丰富多样的调度方法，可以满足各种常规及特殊需求；

灵活的应用方式，例如支持任务和调度的多种组合方式，支持调度数据的多种存储方式；分布式和集群能力，Terracotta 收购后在原来功能基础上作了进一步提升；

作为 Spring 默认的调度框架，Quartz 很容易与 Spring 集成实现灵活可配置的调度功能。

Quartz 核心元素
Scheduler：任务调度器，实际执行任务调度的控制器。在 spring 中通过 SchedulerFactoryBean 封装起来；

Trigger ：触发器，用于定义任务调度的时间规则，有 SimpleTrigger 、 CronTrigger 、

DateIntervalTrigger 和 NthIncludedDayTrigger，其中 CronTrigger 用的比较多，在 spring 中

封装在 CronTriggerFactoryBean 中；

Calendar：一些日历特定时间点的集合。一个 trigger 可以包含多个 Calendar，以便排除或

包含某些时间点；

JobDetail：用来描述 Job 实现类及其它相关的静态信息。如 Job 名字、关联监听器等信息。在 spring 中有 JobDetailFactoryBean 和 MethodInvokingJobDetailFactoryBean 两种实现，如果任务调度只需要执行某个类的某个方法，可以通过 MethodInvokingJobDetailFactoryBean 来调用；

Job: 是一个接口,只有一个方法 void execute(JobExecutionContext context), 开发者实现该接口定义运行任务, JobExecutionContext类提供了调度上下文的各种信息. Job运行时的信息保存在JobDataMap实例中. 实现Job接口的任务,默认是无状态的,若要将Job设置成又状态的,在quartz中是给实现的Job添加@DisallowConcurrentExecution注解,在与spring结合中可以在spring配置文件的job detail中配置concurrent参数.

### 数据库笔试题:

用一条 SQL 语句查询出每门课都大于 80 分的学生姓名

![在这里插入图片描述](https://img-blog.csdnimg.cn/2018111022031368.png) 

```sql
# 准备数据的 sql 代码：

create	table	score(id	int	primary	key	auto_increment,namevarchar(20),subject

varchar(20),score int);

insert into score values

(null,'张三','语文',81),

(null,'张三','数学',75),

(null,'李四','语文',76),

(null,'李四','数学',90),

(null,'王五','语文',81),

(null,'王五','数学',100),

(null,'王五 ','英语',90);

#答案：

#A：select distinct name from score where name not in (select distinct name from score where score<=80)

#B：select distinct name t1 from score where 80< all (select score from score where name=t1)

```

##### 所有球队之间的比赛组合

一张叫 team 的表，里面只有一个字段 name，一共有 4 条纪录，分别是 a、b、c、d，对应四个球队，现在四个球队进行比赛，用一条 sql 语句显示所有可能的比赛组合。

```sql
#答案：select a.name，b.name	from team a, team b where a.name < b.name
```

##### 显示文章标题，发帖人、最后回复时间

表：id，title，postuser，postdate，parentid

准备 sql 语句：

```sql
drop table if exists articles;
create table articles(id int auto_increment primary key,titlevarchar(50), postuser varchar(10), postdate datetime,parentid int referencesarticles(id)); insert into articles values

(null,'第一条','张三','1998-10-10 12:32:32',null), (null,'第二条','张三','1998-10-10 12:34:32',null), (null,'第一条回复 1','李四','1998-10-10 12:35:32',1), (null,'第二条回复 1','李四','1998-10-10 12:36:32',2), (null,'第一条回复 2','王五','1998-10-10 12:37:32',1), (null,'第一条回复 3','李四','1998-10-10 12:38:32',1), (null,'第二条回复 2','李四','1998-10-10 12:39:32',2), (null,'第一条回复 4','王五','1998-10-10 12:39:40',1);

#答案：

select a.title，a.postuser， (select max(postdate) from articles where parentid=a.id ) reply from articles a where a.parentid is null;

#注释：子查询可以用在选择列中，也可用于 where 的比较条件中，还可以用于 from 从句中。
```

#### 航空网的几个航班查询题

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181110234057122.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2NoZW5fMjg5MA==,size_16,color_FFFFFF,t_70) 

##### 1、查询起飞城市是北京的所有航班，按到达城市的名字排序

参与运算的列是我起码能够显示出来的那些列，但最终我不一定把它们显示出来。各个表组合出来的中间结果字段中必须包含所有运算的字段。

```sql
select * from flight f,city c

where f.endcityid =c.cityid and startcityid =

(select c1.cityidfrom city c1 where c1.cityname = "北京")

order by c.citynameasc;

select flight.flightid,'北京' startcity, e.cityname from flight,city e

where flight.endcityid=e.cityid and flight.startcityid=( selectcityid from city where cityname='北京');

select flight.flightid,s.cityname,e.cityname from flight,city s,city e 

where flight.startcityid=s.cityid and s.cityname='北京' andflight.endCityId=e.cit yID order by e.cityName desc;
```

##### 2、查询北京到上海的所有航班纪录（起飞城市，到达城市，起飞时间，航班号）

```sql
select c1.CityName,c2.CityName,f.StartTime,f.flightID

from city c1,city c2,flight f

where f.StartCityID=c1.cityID

and f.endCityID=c2.cityID

and c1.cityName='北京'

and c2.cityName='上海'
```

##### 3、查询具体某一天（2005-5-8）的北京到上海的的航班次数

```sql
Select count(*) from

(select c1.CityName,c2.CityName,f.StartTime,f.flightID

from city c1,city c2,flight f

where f.StartCityID=c1.cityID

and f.endCityID=c2.cityID

and c1.cityName='北京'

and c2.cityName='上海'

and 查帮助获得的某个日期处理函数(startTime) like '2005-5-8%' mysql 中提取日期部分进行比较的示例代码如下：

select * from flight wheredate_format(starttime,'%Y-%m-%d')='1998-01-02'
```

##### DML(Data Manipulation Language)数据操纵语言：

适用范围：对数据库中的数据进行一些简单操作，如insert,delete,update,select等.

##### DDL(Data Definition Language)数据定义语言：

适用范围：对数据库中的某些对象(例如，database,table)进行管理，如Create,Alter和Drop.

##### Shell:

有效电话号码:

```shell

```

## Bean的生命周期?

实例化Bean对象-->设置对象属性-->检查Aware相关接口并设置相关依赖-->BeanPostProcessor前置处理-->检查是否是InitializingBean以决定是否调用afterPropertiesSet方法-->检查是否配置有自定义的init-method-->BeanPostProcessor后置处理-->注册必要的Distruction相关回调接口-->是否实现DisposableBean接口-->是否配置自定义的destroy方法

### 1.讲解一下spring IOC 和 DI ?

IOC:  控制反转,将类的对象的创建交给Spring类管理创建.  DI:    依赖注入,将类里面的属性在创建类的过程中给属性赋值.  DI和IOC的关系: DI不能单独存在,DI需要在IOC的基础上来完成. 

### Spring 中的单例 bean 的线程安全问题了解吗？

单例 bean 存在线程问题，主要是因为当多个线程操作同一个对象的时候，对这个对象的非静态成员变量的写操作会存在线程安全问题。

常见的有两种解决办法：

1. 在Bean对象中尽量避免定义可变的成员变量（不太现实）。
2. 在类中定义一个ThreadLocal成员变量，将需要的可变成员变量保存在 ThreadLocal 中（推荐的一种方式）。

### @Component 和 @Bean 的区别是什么？

1. 作用对象不同: `@Component` 注解作用于类，而`@Bean`注解作用于方法。
2. `@Component`通常是通过类路径扫描来自动侦测以及自动装配到Spring容器中（我们可以使用 `@ComponentScan` 注解定义要扫描的路径从中找出标识了需要装配的类自动装配到 Spring 的 bean 容器中）。`@Bean` 注解通常是我们在标有该注解的方法中定义产生这个 bean,`@Bean`告诉了Spring这是某个类的示例，当我需要用它的时候还给我。
3. `@Bean` 注解比 `Component` 注解的自定义性更强，而且很多地方我们只能通过 `@Bean` 注解来注册bean。比如当我们引用第三方库中的类需要装配到 `Spring`容器时，则只能通过 `@Bean`来实现。

### 2.数据库优化有哪些?

1、调整数据结构的设计。这一部分在开发信息系统之前完成，程序员需要考虑是否使用ORACLE数据库的分区功能，对于经常访问的数据库表是否需要建立索引等。 

2、调整应用程序结构设计。这一部分也是在开发信息系统之前完成，程序员在这一步需要考虑应用程序使用什么样的体系结构，是使用传统的[Client/Server](https://www.baidu.com/s?wd=Client%2FServer&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)两层体系结构，还是使用Browser/Web/Database的三层体系结构。不同的应用程序体系结构要求的数据库资源是不同的。 

3、调整数据库[SQL语句](https://www.baidu.com/s?wd=SQL%E8%AF%AD%E5%8F%A5&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)。应用程序的执行最终将归结为数据库中的[SQL语句](https://www.baidu.com/s?wd=SQL%E8%AF%AD%E5%8F%A5&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)执行，因此[SQL语句](https://www.baidu.com/s?wd=SQL%E8%AF%AD%E5%8F%A5&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)的执行效率最终决定了ORACLE数据库的性能。[ORACLE公司](https://www.baidu.com/s?wd=ORACLE%E5%85%AC%E5%8F%B8&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)推荐使用ORACLE语句优化器（Oracle Optimizer）和行锁管理器（row-level manager）来调整优化SQL语句。 

4、调整服务器[内存分配](https://www.baidu.com/s?wd=%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)。[内存分配](https://www.baidu.com/s?wd=%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)是在信息系统运行过程中[优化配置](https://www.baidu.com/s?wd=%E4%BC%98%E5%8C%96%E9%85%8D%E7%BD%AE&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)的，数据库管理员可以根据数据库运行状况调整数据库系统全局区（SGA区）的[数据缓冲区](https://www.baidu.com/s?wd=%E6%95%B0%E6%8D%AE%E7%BC%93%E5%86%B2%E5%8C%BA&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)、日志缓冲区和共享池的大小；还可以调整程序全局区（PGA区）的大小。需要注意的是，SGA区不是越大越好，SGA区过大会占用操作系统使用的内存而引起[虚拟内存](https://www.baidu.com/s?wd=%E8%99%9A%E6%8B%9F%E5%86%85%E5%AD%98&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)的页面交换，这样反而会降低系统。 

5、调整硬盘I/O，这一步是在信息系统开发之前完成的。数据库管理员可以将组成同一个表空间的数据文件放在不同的硬盘上，做到硬盘之间I/O负载均衡。 

6、调整操作系统参数，例如：运行在[UNIX操作系统](https://www.baidu.com/s?wd=UNIX%E6%93%8D%E4%BD%9C%E7%B3%BB%E7%BB%9F&tn=SE_PcZhidaonwhc_ngpagmjz&rsv_dl=gh_pc_zhidao)上的ORACLE数据库，可以调整UNIX数据缓冲池的大小，每个进程所能使用的内存大小等参数。

### 3.数据库分区怎么做?

分区是要把一个表数据拆分为若干个子集，也就是把一个数据文件拆分到多个数据文件中，然而这些文件的存放可以依托一个文件组或者多个
文件组，由于多个文件组可以提高数据库的访问并发量，还可以把不同的分区配置到不同的磁盘中提高效率，所以创建时建议分区跟文件组
个数相同

1：创建一个或者多个文件组来持有分区(我理解的文件组就是创建几个文件夹来存放数据用的)
2： 在分区过程中使用的每个文件组
3：使用CREATE PARTITION FUNCTION 命令来决定表中的数据如何分区(啪 提神；分开的意思)
4：使用CREATE PARTITION SCHEME 命令来绑定PARTITION FUNCTION到指定文件组(死 给母;方案的意思)

5.创建表,绑定某个分区列到PARTITION SCHEME

```sql
create table t_test (
   pk_id number(30) not null,
  add_date_time  DATE,
   constraintPK_T_TEST primary key (pk_id)
)
PARTITION BY RANGE (add_date_time)
(
  PARTITIONt_test_2013_less VALUES LESS THAN (TO_DATE('2013-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE TS_MISPS,
  PARTITIONt_test_2013 VALUES LESS THAN (TO_DATE('2014-01-01 00:00:00','yyyy-mm-ddhh24:mi:ss')) TABLESPACE TS_MISPS,
  PARTITION t_test_2014VALUES LESS THAN (TO_DATE('2015-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'))TABLESPACE TS_MISPS
);
```



### 4.数据库索引如何创建的?

```
唯一的索引 (Unique Index)
在表格上面创建某个一个唯一的索引。唯一的索引意味着两个行不能拥有相同的索引值。

CREATE UNIQUE INDEX 索引名称
ON 表名称 (列名称) 
"列名称" 规定你需要索引的列。

简单的索引
在表上创建一个简单的索引。当我们省略关键词 UNIQUE 时，就可以使用重复的值。

CREATE INDEX 索引名称
ON 表名称 (列名称)
"列名称" 规定你需要索引的列。
```



### 5.数据库为什么要建立索引?

```
创建索引可以大大提高系统的性能，优点:
　第一，通过创建唯一性索引，可以保证数据库表中每一行数据的唯一性。
　第二，可以大大加快数据的检索速度，这也是创建索引的最主要的原因。
　第三，可以加速表和表之间的连接，特别是在实现数据的参考完整性方面特别有意义。
　第四，在使用分组和排序子句进行数据检索时，同样可以显著减少查询中分组和排序的时间。
　第五，通过使用索引，可以在查询的过程中，使用优化隐藏器，提高系统的性能。 
缺点：
第一，创建索引和维护索引要耗费时间，这种时间随着数据量的增加而增加。
第二，索引需要占物理空间，除了数据表占数据空间之外，每一个索引还要占一定的物理空间，如果要建立聚簇索引，那么需要的空间就会更大。
第三，当对表中的数据进行增加、删除和修改的时候，索引也要动态的维护，这样就降低了数据的维护速度。 
```

### 6.数据库如何分页?

limit

### 7.了解orecle的游标么?

```
数据量大的时候是避免使用游标的,因为游标会对行加锁,影响其他业务的正常运行,相当于把磁盘数据整体放入到了内存当中,内存也是一个限制.
游标
关系数据库中的操作会对整个行集产生影响。由 SELECT 语句返回的行集包括所有满足该语句 WHERE 子句中条件的行。由语句所返回的这一完整的行集被称为结果集。应用程序，特别是交互式联机应用程序，并不总能将整个结果集作为一个单元来有效地处理。这些应用程序需要一种机制以便每次处理一行或一部分行。游标就是提供这种机制的结果集扩展。
游标通过以下方式扩展结果处理：
允许定位在结果集的特定行。
从结果集的当前位置检索一行或多行。
支持对结果集中当前位置的行进行数据修改。
为由其他用户对显示在结果集中的数据库数据所做的更改提供不同级别的可见性支持。
提供脚本、存储过程和触发器中使用的访问结果集中的数据的 Transact-SQL 语句。
```

8.Linux 怎么删除一个文件夹?

9.Dubbo怎么实现的?

### 10.什么是面向oop思想?

```
OOP核心思想：封装，继承，多态。
理解：
对象是由数据和容许的操作组成的封装体，与客观实体有直接对应关系，一个对象类定义了具有相似性质的一组对象。而每继承性是对具有层次关系的类的属性和操作进行共享的一种方式。所谓面向对象就是基于对象概念，以对象为中心，以类和继承为构造机制，来认识、理解、刻画客观世界和设计、构建相应的软件系统。
oop的基本思想：把组件的实现和接口分开，并且让组件具有多态性。
oop概念呢：
它强调对象的“抽象”、“封装”、“继承”、“多态”。我们讲程序设计是由“数据结构”+“算法”组成的。从宏观的角度讲，OOP下的对象是以编程为中心的，是面向程序的对象。我们今天要讲的OOD是面向信息的对象，是以用户信息为中心的。
对象的产生：
一、是以原型（prototype）对象为基础产生新的对象。
二、是以类（class）为基础产生新对象。
```

11.Springboot 单独做了一个短信模块,如果宕机怎么办?

```
最好准备2个网站空间，他们存放的内容相同，而ip不同，并且机房的地理位置不同。这样2个主机， 同时宕机的可能性就大大降低了。第一时间发现宕机问题后，可以迅速的通过修改dnspod.com中的域名记录，指向目前正常的网站空间。Dnspod解析生效的时间是实时的， 而一般的dns服务器，刷新时间较长，对外声称24小时内生效，按照实际经验看来，差不多30分钟内生效，否则就要检查域名绑定是否正确了。
```

### 12.ActiveMQ是怎么做的?

```
第一步:进入 apache-activemq-5.14.0\bin\win64 目录 启动 activemq.bat 文件
第二步:访问：http://localhost:8161/ 用户名和密码 都是 admin
1、 用户注册，重点用户信息数据库保存，发短信、发邮件，增加业务处理复杂度，这时候使用 MQ， 将发短信、发邮箱，通知 MQ，由另外服务平台完成
2、 搜索平台、缓存平台
查询数据，建立缓存、索引 ，不从数据库查询，从缓存或者索引库查询
当增加、修改、删除数据时，发送消息给 MQ， 缓存平台、索引平台 从 MQ 获取到这个信息，更新缓存或者索引

ActiveMQ 使用的是标准生产者和消费者模型
有两种数据结构 Queue、Topic
1、 Queue 队列 ，生产者生产了一个消息，只能由一个消费者进行消费
2、 Topic 话题，生产者生产了一个消息，可以由多个消费者进行消费
默认 tcp 连接 activeMQ 端口 61616 ！！！
```

13.Solr中的IK分词器如何实现的?

14.服务器的部署?

15.需求分析怎么写?

### 16.讲讲分布式事务?

![img](https://images2018.cnblogs.com/blog/434101/201804/434101-20180414142958429-1473438816.png) 

```
1、CAP理论
在分布式系统中，一致性（Consistency）、可用性（Availability）和分区容忍性（Partition Tolerance）3 个要素最多只能同时满足两个，不可兼得。其中，分区容忍性又是不可或缺的。

数据的一致性模型可以分成以下 3 类：
强一致性：数据更新成功后，任意时刻所有副本中的数据都是一致的，一般采用同步的方式实现。
弱一致性：数据更新成功后，系统不承诺立即可以读到最新写入的值，也不承诺具体多久之后可以读到。
最终一致性：弱一致性的一种形式，数据更新成功后，系统不承诺立即可以返回最新写入的值，但是保证最终会返回上一次更新操作的值。

分布式事务方案
强一致性
2PC 两阶段提交（XA事务，阻塞）
2PC协议：一种协议，在分布式系统保证事务的原子提交
XA：分布式事务规范

```

### 17.单点登陆的实现?

```
单点登录涉及SSO认证中心与多个子系统，子系统与SSO认证中心需要通信（交换令牌、校验令牌及发起注销请求等），子系统中包含SSO的客户端，SSO认证中心是服务端
认证中心与客户端通信可通过 httpClient、web service、rpc、restful api（url是其中一种） 等实现
客户端与服务器端的功能
客户端：
拦截子系统未登录用户请求，跳转至sso认证中心
接收并存储sso认证中心发送的令牌
与服务器端通信，校验令牌的有效性
建立局部会话
拦截用户注销请求，向sso认证中心发送注销请求
接收sso认证中心发出的注销请求，销毁局部会话
服务器端：
验证用户的登录信息
创建全局会话
创建授权令牌
与客户端通信发送令牌
校验客户端令牌有效性
系统注册
接收客户端注销请求，注销所有会话
```

### 18.ActiveMQ用到了哪些设计模式?

### 19.装饰者模式的介绍?

装饰者模式又名包装(Wrapper)模式。装饰者模式以对客户端透明的方式扩展对象的功能，是继承关系的一个替代方案。

装饰者模式动态地将责任附加到对象身上。若要扩展功能，装饰者提供了比继承更有弹性的替代方案。

在装饰模式中的角色有：

●　　抽象构件(Component)角色：给出一个抽象接口，以规范准备接收附加责任的对象。

●　　具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。

●　　装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。

●　　具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。

装饰者模式在Java IO流中的应用

装饰者模式在Java语言中的最著名的应用莫过于Java I/O标准库的设计了。

由于Java I/O库需要很多性能的各种组合，如果这些性能都是用继承的方法实现的，那么每一种组合都需要一个类，这样就会造成大量性能重复的类出现。而如果采用装饰者模式，那么类的数目就会大大减少，性能的重复也可以减至最少。因此装饰者模式是Java I/O库的基本模式。

### 20.怎么确定ActiveMQ被消费?

监听器，监听消费端的某个必执行的方法范围时间内是否被调用，如果未被调用则可认定为已经消费完。 

### 21.B+和b数有什么区别?

```
为什么要B树
磁盘中有两个机械运动的部分，分别是盘片旋转和磁臂移动。盘片旋转就是我们市面上所提到的多少转每分钟，而磁盘移动则是在盘片旋转到指定位置以后，移动磁臂后开始进行数据的读写。那么这就存在一个定位到磁盘中的块的过程，而定位是磁盘的存取中花费时间比较大的一块，毕竟机械运动花费的时候要远远大于电子运动的时间。当大规模数据存储到磁盘中的时候，显然定位是一个非常花费时间的过程，但是我们可以通过B树进行优化，提高磁盘读取时定位的效率。

简介
这里的B树，也就是英文中的B-Tree，一个 m 阶的B树满足以下条件：

每个结点至多拥有m棵子树；
除了根结点以外，其余每个分支结点至少拥有 m/2 棵子树；
根结点至少拥有两颗子树（存在子树的情况下）；
所有的叶结点都在同一层上，其可以看作是外部结点，不包含任何信息；
有 k 棵子树的非叶子结点则其存在 k-1 个关键码，关键码按照递增次序进行排列；
关键字数量需要满足ceil(m/2)-1 <= n <= m-1；
```



```
这都是由于B+树和B具有这不同的存储结构所造成的区别，以一个m阶树为例。

关键字的数量不同；B+树中分支结点有m个关键字，其叶子结点也有m个，其关键字只是起到了一个索引的作用，但是B树虽然也有m个子结点，但是其只拥有m-1个关键字。
存储的位置不同；B+树中的数据都存储在叶子结点上，也就是其所有叶子结点的数据组合起来就是完整的数据，但是B树的数据存储在每一个结点中，并不仅仅存储在叶子结点上。
分支结点的构造不同；B+树的分支结点仅仅存储着关键字信息和儿子的指针（这里的指针指的是磁盘块的偏移量），也就是说内部结点仅仅包含着索引信息。
查询不同；B树在找到具体的数值以后，则结束，而B+树则需要通过索引找到叶子结点中的数据才结束，也就是说B+树的搜索过程中走了一条从根结点到叶子结点的路径。
```

### 22.假如有一批商品,进行增删改查,但是他们的属性不一样,怎么做?

```
1、首先有商品种类表、属性表、属性值表。
2、属性表中有种类id，和属性值类型字段，这个值类型字段是记录商品种类的属性值类型的。分为三种：文本属性（描述类的），下拉框属性（单选类的尺寸）、勾选框多选类（颜色风格等）。
3、属性值表是对应属性表中，属性值类型为下拉框和多选框的值的表。
4、发布商品的时候会根据选择的小类出现对应的属性，然后填写或勾选属性值。保存的时候会根据不同的属性值类型保存到三个表中，文本描述性的、下拉框形式、多选框形式的。
5、后期维护的时候，直接对属性表和属性值表维护即可，不管是对已有的种类添加属性，还是新添加的种类要添加新属性，都可以。
```

### 23.B+数遍历前序排序中序后序排序有什么区别?

```
先，根左右
中，左根右
后，左右根
```



### 24.一亿个数要找到前100个最大的数应该怎么做?



### 25.HashMap的实现原理?

HashMap是对数据结构中哈希表(Hash Table)的实现， Hash表又叫散列表。Hash表是根据关键码Key来访问其对应的值Value的数据结构，它通过一个映射函数把关键码映射到表中一个位置来访问该位置的值，从而加快查找的速度。这个映射函数叫做Hash函数，存放记录的数组叫做Hash表。在Java中，HashMap的内部实现结合了链表和数组的优势，链接节点的数据结构是 Entry<k,v>，每个Entry对象的内部又含有指向下一个Entry类型对象的引用

### 26.HashMap什么时候会进行rehash?

HashMap的内部实现机制时提到了两个参数，DEFAULT_INITIAL_CAPACITY和DEFAULT_LOAD_FACTOR，DEFAULT_INITIAL_CAPACITY是table数组的容量，DEFAULT_LOAD_FACTOR则是为了最大程度避免哈希冲突，提高HashMap效率而设置的一个影响因子，将其乘以DEFAULT_INITIAL_CAPACITY就得到了一个阈值threshold，当HashMap的容量达到threshold时就需要进行扩容，这个时候就要进行ReHash操作了，可以看到下面addEntry函数的实现，当size达到threshold时会调用resize函数进行扩容 在扩容的过程中需要进行ReHash操作，而这是非常耗时的，在实际中应该尽量避免。 

### 27.HashMap什么时候进行扩容?

当HashMap的容量达到threshold时就需要进行扩容, DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY = threshold(阀值)

### 28.HashMap的初始容量设置成多少比较合适?

initialCapacity = (需要存储的元素个数/负载因子) + 1. 注:负载因子(loaderfactor)默认为0.75. hashmap在我们存放的数据大于初始化容量*负载因子（默认0.75）时就会自动扩容，自动扩容是非常消耗性能的。因为元素要重新hash分配。当我们生成了一个7容量的map，jdk会生成一个8容量的map，那么存放到8 * 0.75 = 6个元素时就会扩容了，跟我们预想放7个有偏差. 

### 29.结合源码说说HashMap在高并发场景中为什么会出现死循环?

```java
HashMap进行存储时，假设size超过当前最大容量*负载因子时候会发生resize。 
/*
resize()方法如下，重要的是transfer方法，把旧表中的元素添加到新表中
*/
void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;
        if (oldCapacity == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }
 
        Entry[] newTable = new Entry[newCapacity];
        transfer(newTable);
        table = newTable;
        threshold = (int)(newCapacity * loadFactor);
    }
而这段代码中又调用了transfer()方法，而这种方法实现的机制就是将每一个链表转化到新链表，而且链表中的位置发生反转，而这在多线程情况下是非常容易造成链表回路。从而发生get()死循环。
void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            Entry<K,V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K,V> next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    e.next = newTable[i];
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }
    
假如有两个线程P1、P2，以及链表 a=>b=>null

1、P1先运行，运行完"Entry<K,V> next = e.next;"代码后发生堵塞，或者其它情况不再运行下去，此时e=a。next=b

2、而P2已经运行完整段代码，于是当前的新链表newTable[i]为b=>a=>null

3、P1又继续运行"Entry<K,V> next = e.next;"之后的代码，则运行完"e=next;"后，newTable[i]为a<=>b。则造成回路，while(e!=null)一直死循环
```

主要原因: 是因为多线程会导致HashMap的Entry链表形成环形数据结构，查找时会陷入死循环。 

### 30.JDK1.8中对HashMap做了哪些性能优化?

JDK 8 中采用的是位桶 + 链表/红黑树的方式，当某个位桶的链表的长度超过 8 的时候，这个链表就将转换成红黑树HashMap 不会因为多线程 put 导致死循环（JDK 8 用 head 和 tail 来保证链表的顺序和之前一样；JDK 7 rehash 会倒置链表元素），但是还会有数据丢失等弊端（并发本身的问题）。因此多线程情况下还是建议使用 ConcurrentHashMap

### 31.HashMap和HashTable有什么区别?

Hashtable既不支持Null key也不支持Null value。Hashtable的put()方法的注释中有说明 。

HashMap中,null可以作为键,这样的键只有一个;可以有一个或多个键所对应的的值为null.当get()方法返回null值时,可能时HashMap中没有该键, 也可能使该键所对应的值为null.因此,在HashMap中不能由get()方法来判断HashMap中是否存在某个键,而应该用containsKey()方法来判断.

Hashtable是线程安全的，它的每个方法中都加入了Synchronize方法。在多线程并发的环境下，可以直接使用Hashtable，不需要自己为它的方法实现同步

HashMap不是线程安全的，在多线程并发的环境下，可能会产生死锁等问题

Hashtable、HashMap都使用了Iterator。而由于历史原因，Hashtable还使用了Enumeration的方式 。 

Hashtable的初始长度是11，之后每次扩充容量变为之前的2n+1（n为上一次的长度）

而HashMap的初始长度为16，之后每次扩充变为原来的两倍

创建时，如果给定了容量初始值，那么Hashtable会直接使用你给定的大小，而HashMap会将其扩充为2的幂次方大小。

### 32.HashMap和ConcurrentHashMap的区别?

ConcurrentHashMap比HashMap多出了一个类Segment，而Segment是一个可重入锁。ConcurrentHashMap是使用了锁分段技术来保证线程安全的。

**锁分段技术**：首先将数据分成一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。 

ConcurrentHashMap提供了与Hashtable和SynchronizedMap不同的锁机制。Hashtable中采用的锁机制是一次锁住整个hash表，从而在同一时刻只能由一个线程对其进行操作；而ConcurrentHashMap中则是一次锁住一个桶。

ConcurrentHashMap默认将hash表分为16个桶，诸如get、put、remove等常用操作只锁住当前需要用到的桶。这样，原来只能一个线程进入，现在却能同时有16个写线程执行，并发性能的提升是显而易见的。

### 33.ConcurrentHashMap和LinkedHashMap有什么区别?

### 34.为什么ConcurrentHashMap中的链表转红黑树的阀值是8?

### 35.什么是ConcurrentSkipListMap?和ConcurrentHashMap有什么区别?

ConcurrentSkipListMap的底层是通过跳表来实现的。跳表是一个链表，但是通过使用“跳跃式”查找的方式使得插入、读取数据时复杂度变成了O（logn）。

跳表（SkipList）：使用“空间换时间”的算法，令链表的每个结点不仅记录next结点位置，还可以按照level层级分别记录后继第level个结点。在查找时，首先按照层级查找，比如：当前跳表最高层级为3，即每个结点中不仅记录了next结点（层级1），还记录了next的next（层级2）、next的next的next（层级3）结点。现在查找一个结点，则从头结点开始先按高层级开始查：head->head的next的next的next->。。。直到找到结点或者当前结点q的值大于所查结点，则此时当前查找层级的q的前一节点p开始，在p~q之间进行下一层级（隔1个结点）的查找......直到最终迫近、找到结点。此法使用的就是“**先大步查找确定范围，再逐渐缩小迫近**”的思想进行的查找。

ConcurrentSkipListMap线程安全的原理与非阻塞队列ConcurrentBlockingQueue的原理一样：利用底层的插入、删除的CAS原子性操作，通过死循环不断获取最新的结点指针来保证不会出现竞态条件.

### 36.Springboot中starter怎么实现的?

利用starter实现自动化配置只需要两个条件——maven依赖、配置文件，这里简单介绍下starter实现自动化配置的流程。引入maven实质就是导入jar包,spring-boot启动的时候会找到start jar包中的resource/META-INF/spring.factories文件,根据spring.factories文件中的配置,找到需要自动配置的类

### 37.为什么HashMap线程不安全?

HashMap 在并发时可能出现的问题主要是两方面：

- 如果多个线程同时使用 put 方法添加元素，而且假设正好存在两个 put 的 key 发生了碰撞（根据 hash 值计算的 bucket 一样），那么根据 HashMap 的实现，这两个 key 会添加到数组的同一个位置，这样最终就会发生其中一个线程 put 的数据被覆盖
- 如果多个线程同时检测到元素个数超过数组大小 * loadFactor，这样就会发生多个线程同时对 Node 数组进行扩容，都在重新计算元素位置以及复制数据，但是最终只有一个线程扩容后的数组会赋给 table，也就是说其他线程的都会丢失，并且各自线程 put 的数据也丢失

## 算法:

#### 冒泡排序:

```java

public class BubbleSort {
    public void bubbleSort(Integer[] arr, int n) {
        if (n <= 1) return;       //如果只有一个元素就不用排序了
 
        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
    }
 
    public static void main(String[] args) {
        Integer arr[] = {2, 4, 7, 6, 8, 5, 9};
        SortUtil.show(arr);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr, arr.length);
        SortUtil.show(arr);
    }
}
```

#### 选择排序:

```java
//选择排序
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }        
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){ 
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }    
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
}
```

#### 选择排序:

```java
public static void selectSort(int[]a){
    int minIndex=0;
    int temp=0;

    for(int i=0;i<a.length-1;i++) {
        minIndex=i;//无序区的最小数据数组下标
        for(intj=i+1;j<a.length;j++) {
            //在无序区中找到最小数据并保存其数组下标
            if(a[j]<a[minIndex]) {
                minIndex=j;
            }
        }
        //将最小元素放到本次循环的前端
        temp=a[i];
        a[i]=a[minIndex];
        a[minIndex]=temp;
    }
}
```

## 微服务:

微服务是一种面向服务的架构(SOA)风格（Java开发人员最重要的技能之一），其中，应用程序被构建为多个不同的小型服务的集合而不是单个应用程序。与单个程序不同的是，微服务让你可以同时运行多个独立的应用程序，而这些独立的应用程序可以使用不同的编码或编程语言来创建。庞大而又复杂的应用程序可以由多个可自行执行的简单而又独立的程序所组成。这些较小的程序组合在一起，可以提供庞大的单程序所具备的所有功能。

微服务是一种面向服务的架构风格,具有灵活性和低成本两个特点.  灵活性:由于这些较小的应用程序无需使用相同的编程语言,因此,开发人员可以使用他们最熟悉的语言,这是灵活性. 低成本:由于他们都用自己擅长的语言去开发,所以效率会高,相应的开发成本会降低.

## 分布式:

所谓分布式,无非就是将一个系统拆分成多个子系统并分布到多个服务器上.

简单的说，是指将用户界面、控制台服务、数据库管理三个层次部署在不同的位置上。其中用户界面是客户端实现的功能，控制台服务是一个专门的服务器，数据管理是在一个专门的数据库服务器上实现的。

分布式常用框架:Dubbo, MQ消息队列,Zeekeeper等.

----------------------------------------------------

**集群是个物理形态，分布式是个工作方式。**

- 分布式：一个业务分拆多个子业务，部署在不同的服务器上
- 集群：同一个业务，部署在多个服务器上

**分布式是指将不同的业务分布在不同的地方。而集群指的是将几台服务器集中在一起，实现同一业务。** 

**微服务是一种架构风格，一个大型复杂软件应用由一个或多个微服务组成。系统中的各个微服务可被独立部署，各个微服务之间是松耦合的。每个微服务仅关注于完成一件任务并很好地完成该任务。在所有情况下，每个任务代表着一个小的业务能力。** 

springboot 文件加载顺序 一般默认加载application.propertise 或者 application.yml文件 jar包目录下 1.config 2.jar同级目录 class目录下 3.config目录 4.class同级目录 相同属性 按照优先级最高的匹配  另外：可以在启动命令中 加入 --spring.config.location 指定文件地址 多个文件用 ","隔开 



nginx在部署的时候有哪些必要的配置,有哪些是可以调优的?

- net.core.somaxconn：排队等待连接的最大数目，由NGINX可接受的数目决定。默认值通常很低，但可以接受，因为NGINX 接收连接非常快，但如果网站流量大时，就应该增加这个值。内核日志中的错误消息会提醒这个值太小了，把值改大，直到错误提示消失。

  注意： 如果设置这个值大于512，相应地也要改变NGINX listen指令的backlog参数。

- net.core.netdev_max_backlog ： 在提交到CPU前网卡中数据包缓冲的速率，高带宽下提高这个值可提高性能。检查内核日志文件中有关这个设置的错误，根据网卡文档中的建议修改这个值。

- 如果NGINX充当代理时，通常一个文件描述符表示客户端连接，另一个连接到代理服务器，如果开启了HTTP 保持连接，这个比例会更低（译注：为什么更低呢）。对于有大量连接服务的系统，下面的设置可能需要调整一下：

  - sys.fs.file_max —— 文件描述符系统级别的限制

- 当NGINX充当代理时，每个到上游服务器的连接都使用一个短暂或临时端口。可能需要修改这些设置：

  - net.ipv4.ip_local_port_range —— 端口值的起止范围。如果你发现用尽端口号，可以增大端口范围。一般端口号设置是1024到65000。

- 你可以设置多个限制，防止用户消耗太多的资源，避免影响系统性能和用户体验及安全。 以下是相关的指令：

  - limit_conn and limit_conn_zone—NGINX接受客户连接的数量限制，例如单个IP地址的连接。设置这些指令可以防止单个用户打开太多的连接，消耗超出自己的资源。
  - limit_rate–传输到客户端响应速度的限制（每个打开多个连接的客户消耗更多的带宽）。设置这个限制防止系统过载，确保所有客户端更均匀的服务质量。
  - limit_req and limit_req_zone– NGINX处理请求的速度限制，与limit_rate有相同的功能。可以提高安全性，尤其是对登录页面，通过对用户限制请求速率设置一个合理的值，避免太慢的程序覆盖你的应用请求（比如DDoS攻击)。
  - max_conns上游配置块中服务器指令参数。在上游服务器组中单个服务器可接受最大并发数量。使用这个限制防止上游服务器过载。设置值为0（默认值）表示没有限制。
  - queue (NGINX Plus) – 创建一个队列，用来存放在上游服务器中超出他们最大max_cons限制数量的请求。这个指令可以设置队列请求的最大值，还可以选择设置在错误返回之前最大等待时间（默认值是60秒）。如果忽略这个指令，请求不会放入队列。

- 记录每个请求会消耗CPU和I/O周期，一种降低这种影响的方式是缓冲访问日志。使用缓冲，而不是每条日志记录都单独执行写操作，NGINX会缓冲一连串的日志记录，使用单个操作把它们一起写到文件中。

  要启用访问日志的缓存，就涉及到在access_log指令中buffer=size这个参数。当缓冲区达到size值时，NGINX会把缓冲区的内容写到日志中。让NGINX在指定的一段时间后写缓存，就包含flush=time参数。当两个参数都设置了，当下个日志条目超出缓冲区值或者缓冲区中日志条目存留时间超过设定的时间值，NGINX都会将条目写入日志文件。当工作进程重新打开它的日志文件或退出时，也会记录下来。要完全禁用访问日志记录的功能，将access_log 指令设置成off参数。

说说uWSGI的工作原理,底层到底是怎么实现的?

### Redis是什么,底层,怎么用?

简单来说 redis 就是一个数据库，不过与传统数据库不同的是 redis 的数据是存在内存中的，所以读写速度非常快，因此 redis 被广泛应用于缓存方向。另外，redis 也经常用来做分布式锁。 

### redis 内存淘汰机制:

1. **volatile-lru**：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰
2. **volatile-ttl**：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰
3. **volatile-random**：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰
4. **allkeys-lru**：当内存不足以容纳新写入数据时，在键空间中，移除最近最少使用的key（这个是最常用的）
5. **allkeys-random**：从数据集（server.db[i].dict）中任意选择数据淘汰
6. **no-eviction**：禁止驱逐数据，也就是说当内存不足以容纳新写入数据时，新写入操作会报错

### redis 持久化机制(怎么保证 redis 挂掉之后再重启数据可以进行恢复)

Redis不同于Memcached的很重一点就是，Redis支持持久化，而且支持两种不同的持久化操作。**Redis的一种持久化方式叫快照（snapshotting，RDB），另一种方式是只追加文件（append-only file,AOF）**。 

Redis可以通过创建快照来获得存储在内存里面的数据在某个时间点上的副本。Redis创建快照之后，可以对快照进行备份，可以将快照复制到其他服务器从而创建具有相同数据的服务器副本（Redis主从结构，主要用来提高Redis性能），还可以将快照留在原地以便重启服务器的时候使用。

快照持久化是Redis默认采用的持久化方式，在redis.conf配置文件中默认有此下配置：

```shell
save 900 1           #在900秒(15分钟)之后，如果至少有1个key发生变化，Redis就会自动触发BGSAVE命令创建快照。

save 300 10          #在300秒(5分钟)之后，如果至少有10个key发生变化，Redis就会自动触发BGSAVE命令创建快照。

save 60 10000        #在60秒(1分钟)之后，如果至少有10000个key发生变化，Redis就会自动触发BGSAVE命令创建快照。
```

**AOF（append-only file）持久化**

与快照持久化相比，AOF持久化 的实时性更好，因此已成为主流的持久化方案。默认情况下Redis没有开启AOF（append only file）方式的持久化，可以通过appendonly参数开启：

```shell
appendonly yes
```

开启AOF持久化后每执行一条会更改Redis中的数据的命令，Redis就会将该命令写入硬盘中的AOF文件。AOF文件的保存位置和RDB文件的位置相同，都是通过dir参数设置的，默认的文件名是appendonly.aof。

在Redis的配置文件中存在三种不同的 AOF 持久化方式，它们分别是：

```shell
appendfsync always    #每次有数据修改发生时都会写入AOF文件,这样会严重降低Redis的速度
appendfsync everysec  #每秒钟同步一次，显示地将多个写命令同步到硬盘
appendfsync no        #让操作系统决定何时进行同步
```

为了兼顾数据和写入性能，用户可以考虑 appendfsync everysec选项 ，让Redis每秒同步一次AOF文件，Redis性能几乎没受到任何影响。而且这样即使出现系统崩溃，用户最多只会丢失一秒之内产生的数据。当硬盘忙于执行写入操作的时候，Redis还会优雅的放慢自己的速度以便适应硬盘的最大写入速度。

### redis 事务

Redis 通过 MULTI、EXEC、WATCH 等命令来实现事务(transaction)功能。事务提供了一种将多个命令请求打包，然后一次性、按顺序地执行多个命令的机制，并且在事务执行期间，服务器不会中断事务而改去执行其他客户端的命令请求，它会将事务中的所有命令都执行完毕，然后才去处理其他客户端的命令请求。

在传统的关系式数据库中，常常用 ACID 性质来检验事务功能的可靠性和安全性。在 Redis 中，事务总是具有原子性（Atomicity）、一致性（Consistency）和隔离性（Isolation），并且当 Redis 运行在某种特定的持久化模式下时，事务也具有持久性（Durability）。

### 如何解决 Redis 的并发竞争 Key 问题

所谓 Redis 的并发竞争 Key 的问题也就是多个系统同时对一个 key 进行操作，但是最后执行的顺序和我们期望的顺序不同，这样也就导致了结果的不同！

推荐一种方案：分布式锁（zookeeper 和 redis 都可以实现分布式锁）。（如果不存在 Redis 的并发竞争 Key 问题，不要使用分布式锁，这样会影响性能）

基于zookeeper临时有序节点可以实现的分布式锁。大致思想为：每个客户端对某个方法加锁时，在zookeeper上的与该方法对应的指定节点的目录下，生成一个唯一的瞬时有序节点。 判断是否获取锁的方式很简单，只需要判断有序节点中序号最小的一个。 当释放锁的时候，只需将这个瞬时节点删除即可。同时，其可以避免服务宕机导致的锁无法释放，而产生的死锁问题。完成业务流程后，删除对应的子节点释放锁。

### 如何保证缓存与数据库双写时的数据一致性?

一般来说，就是如果你的系统不是严格要求缓存+数据库必须一致性的话，缓存可以稍微的跟数据库偶尔有不一致的情况，最好不要做这个方案，读请求和写请求串行化，串到一个内存队列里去，这样就可以保证一定不会出现不一致的情况

串行化之后，就会导致系统的吞吐量会大幅度的降低，用比正常情况下多几倍的机器去支撑线上的一个请求。

### 缓存雪崩和缓存穿透问题解决方案

缓存同一时间大面积的失效，所以，后面的请求都会落到数据库上，造成数据库短时间内承受大量请求而崩掉。 

- 事前：尽量保证整个 redis 集群的高可用性，发现机器宕机尽快补上。选择合适的内存淘汰策略。
- 事中：本地ehcache缓存 + hystrix限流&降级，避免MySQL崩掉
- 事后：利用 redis 持久化机制保存的数据尽快恢复缓存

### 分布式锁的三种实现方式?

跨JVM的互斥机制来控制共享资源的访问 

基于数据库实现分布式锁；  基于缓存（Redis等）实现分布式锁；  基于Zookeeper实现分布式锁； 分布式事务、分布式锁 来保证分布式的数据一致性

基于Redis实现:获取锁

使用命令:

```java
SET resource_name my_random_value NX PX 30000
-----------------------------------------------------------------------------------------------
try{
	lock = redisTemplate.opsForValue().setIfAbsent(lockKey, LOCK);
	logger.info("cancelCouponCode是否获取到锁："+lock);
	if (lock) {
		// TODO
		redisTemplate.expire(lockKey,1, TimeUnit.MINUTES); //成功设置过期时间
		return res;
	}else {
		logger.info("cancelCouponCode没有获取到锁，不执行任务!");
	}
}finally{
	if(lock){	
		redisTemplate.delete(lockKey);
		logger.info("cancelCouponCode任务结束，释放锁!");		
	}else{
		logger.info("cancelCouponCode没有获取到锁，无需释放锁!");
	}
}
```

缺点：

 在这种场景（主从结构）中存在明显的竞态:

​    客户端A从master获取到锁，
    在master将锁同步到slave之前，master宕掉了。
    slave节点被晋级为master节点，
    客户端B取得了同一个资源被客户端A已经获取到的另外一个锁。**安全失效**！

关系型数据库表的存储结构?

关系数据结构的重点在于“实体”与“关系”的选择 

什么是最小堆,什么是最大堆?在堆中怎么插入一个元素?

最大堆：根结点的键值是所有堆结点键值中最大者，且每个结点的值都比其孩子的值大。

最小堆：根结点的键值是所有堆结点键值中最小者，且每个结点的值都比其孩子的值小。

```c
MaxHeap<T> &Insert(const T&x)  
    {     
        if(CurrentSize == MaxSize)  
            exit(1);        //没有足够空间  
  
        //为x寻找应插入位置  
        //i从新的叶节点开始，并沿着树上升  
        int i = ++ CurrentSize;  
        while(i != 1 && x > heap[i/2])  
        {  
            //不把x放进heap[i]  
            heap[i] = heap[i/2];        //元素下移  
            i /= 2;     //移向父节点  
        }  
        heap[i] = x;        //这时候才把x放进去  
        return *this;  
    }  
```

DO, DTO, BO, AO, VO, POJO的定义

```
DO（ Data Object）：与数据库表结构一一对应，通过DAO层向上传输数据源对象。
DTO（ Data Transfer Object）：数据传输对象，Service或Manager向外传输的对象。
BO（ Business Object）：业务对象。 由Service层输出的封装业务逻辑的对象。
AO（ Application Object）：应用对象。 在Web层与Service层之间抽象的复用对象模型，极为贴近展示层，复用度不高。
VO（ View Object）：显示层对象，通常是Web向模板渲染引擎层传输的对象。
POJO（ Plain Ordinary Java Object）：在本手册中， POJO专指只有setter/getter/toString的简单类，包括DO/DTO/BO/VO等。
Query：数据查询对象，各层接收上层的查询请求。 注意超过2个参数的查询封装，禁止使用Map类来传输。
领域模型命名规约：
数据对象：xxxDO，xxx即为数据表名。
数据传输对象：xxxDTO，xxx为业务领域相关的名称。
展示对象：xxxVO，xxx一般为网页名称。
POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO。
```

如何给一个双向链表排序?

```java
package leedcode;
import java.util.Arrays;
import java.util.List;
/**
 * 双向链表快排
 */
public class DoubleLinkedListQuickSort {
    static class Node {
        int value;
        Node pre;
        Node next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return String.valueOf(this.value);
            }
            return this.value + "->" + this.next.toString();
        }
    }
    /**
     * 参数为头节点和尾节点
     */
    public static void quickSort(Node head, Node tail) {
        if (head == null || tail == null || head == tail || head.next == tail) {
            return;
        }

        if (head != tail) {
            Node mid = getMid(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }
    public static Node getMid(Node start, Node end) {
        int base = start.value;
        while (start != end) {
            while (start != end && base <= end.value) {
                end = end.pre;
            }
            start.value = end.value;
            while (start != end && base >= start.value) {
                start = start.next;
            }
            end.value = start.value;
        }
        start.value = base;
        return start;
    }
    /**
     * 使用如内部实现使用双向链表的LinkedList容器实现的快排
     */
    public static void quickSort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, 0, list.size() - 1);
    }

    private static void quickSort(List<Integer> list, int i, int j) {
        if (i < j) {
            int mid = partition(list, i, j);
            partition(list, i, mid);
            partition(list, mid + 1, j);
        }
    }

    private static int partition(List<Integer> list, int i, int j) {
        int baseVal = list.get(i);
        while (i < j) {
            while (i < j && baseVal <= list.get(j)) {
                j--;
            }
            list.set(i, list.get(j));
            while (i < j && baseVal >= list.get(i)) {
                i++;
            }
            list.set(j, list.get(i));
        }
        list.set(i, baseVal);
        return i;
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(0);

        node1.next = node2;
        node2.pre = node1;

        node2.next = node3;
        node3.pre = node2;

        node3.next = node4;
        node4.pre = node3;

        node4.next = node5;
        node5.pre = node4;

        node5.next = node6;
        node6.pre = node5;

        System.out.println("Origin link: " + node1);
        quickSort(node1, node6);
        System.out.println("Sorted link: " + node1);

        Integer[] l = {2, 3, 4, 1, 0, 5};
        // 可在此处使用LinkedList容器存储
        List<Integer> list = Arrays.asList(l);
        quickSort(list);
        System.out.println("Sorted list: " + list);
    }
}
```

### @Cacheable

- **value：缓存位置名称**，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
- **key：缓存的key**，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
- **condition：触发条件**，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL

```java

//将缓存保存进andCache，并使用参数中的userId加上一个字符串(这里使用方法名称)作为缓存的key   
@Cacheable(value="andCache",key="#userId + 'findById'")  
public SystemUser findById(String userId) {  
    SystemUser user = (SystemUser) dao.findById(SystemUser.class, userId);        
    return user ;         
}  
//将缓存保存进andCache，并当参数userId的长度小于32时才保存进缓存，默认使用参数值及类型作为缓存的key  
@Cacheable(value="andCache",condition="#userId.length < 32")  
public boolean isReserved(String userId) {  
    System.out.println("hello andCache"+userId);  
    return false;  
} </span>
```

### **@CacheEvict** 

- **value：缓存位置名称**，不能为空，同上
- **key：缓存的key**，默认为空，同上
- **condition：触发条件**，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
- **allEntries：**true表示清除value中的全部缓存，默认为false

```java
  @CacheEvict(value="users", allEntries=true)
   public void delete(Integer id) {
      System.out.println("delete user by id: " + id);
   }
   //清除掉指定key的缓存  
    @CacheEvict(value="andCache",key="#user.userId + 'findById'")  
    public void modifyUserRole(SystemUser user) {  
             System.out.println("hello andCache delete"+user.getUserId());  
    }  
    //清除掉全部缓存  
    @CacheEvict(value="andCache",allEntries=true)  
    public final void setReservedUsers(String[] reservedUsers) {  
        System.out.println("hello andCache deleteall");  
    }</span>  
```

## 限流一般有三种: 计数器 、漏桶算法、令牌桶算 

```shell
1.先说下nginx里面配置直接返回json如何操作。

	location /json/ {
	    default_type application/json;
	    add_header Content-Type 'text/html; charset=utf-8';
	    return 200 '{"code":"6666,"msg":"访问高峰期..."}';
        }
#限流
limit_req_zone $binary_remote_addr zone=myRateLimit:10m rate=2r/s;
server{
	location / { 
            #限流
            limit_req zone=myRateLimit burst=2 nodelay;
            root   html;
            index  index.html index.htm;
        }
      }
第1个参数:limit_req_zone定义在http块中，$binary_remote_addr表示保存客户端IP地址的二进制形式。
第2个参数:Zone定义IP状态及URL访问频率的共享内存区域。zone=keyword标识区域的名字，以及冒号后面跟区域大小。16000个IP地址的状态信息约1MB，所以示例中区域可以存储160000个IP地址。
第3个参数:Rate定义最大请求速率。示例中速率不能超过每秒2个请求。

ngx_http_limit_conn_module 提供了限制连接数的能力，利用 limit_conn_zone 和 limit_conn 两个指令即可。

limit_conn_zone $binary_remote_addr zone=perip:10m;
limit_conn_zone $server_name zone=perserver:10m;

server {
    ...
    limit_conn perip 10;
    limit_conn perserver 100;
}
limit_conn perip 10 作用的key 是 $binary_remote_addr，表示限制单个IP同时最多能持有10个连接。
limit_conn perserver 100 作用的key是 $server_name，表示虚拟主机(server) 同时能处理并发连接的总数。
需要注意的是：只有当 request header 被后端server处理后，这个连接才进行计数。
```

## Mybatis:

### bind:

```sql
bind 标签可以使用 OGNL 表达式创建一个变量并将其绑定到上下文中。在前面的例子中，UserMapper.xml 有一个selectByUser 方法，这个方法用到了 like 查询条件，部分代码如下。

<if test="userName != null and userName != ''">
and user_name like concat('%', #{userName}, '%')
</if>

使用 concat 函数连接字符串，在 MySQL 中，这个函数支持多个参数，但在 Oracle 中只支持两个参数。由于不同数据库之间的语法差异，如果更换数据库，有些 SQL 语句可能就需要重写。针对这种情况，可以使用 bind 标签来避免由于更换数据库带来的一些麻烦。将上面的方法改为 bind 方式后，代码如下。

<if test="userName != null and userName != ''">
    <bind name="userNameLike" value="'%' + userName + '%'"/>
    and user_name like #{userNameLike}
</if>

bind 标签的两个属性都是必选项，name 为绑定到上下文的变量名，value 为 OGNL 表达式。创建一个 bind 标签的变量后，就可以在下面直接使用，使用 bind 拼接字符串不仅可以避免因更换数据库而去修改 SQL，也能预防 SQL 注入。
```

## MQ:

MQ的好处：**解耦**、**异步**、**削峰** 

缺点有以下几个：

- 系统可用性降低
  系统引入的外部依赖越多，越容易挂掉。本来你就是 A 系统调用 BCD 三个系统的接口就好了，人 ABCD 四个系统好好的，没啥问题，你偏加个 MQ 进来，万一 MQ 挂了咋整，MQ 一挂，整套系统崩溃的，你不就完了？如何保证消息队列的高可用，可以[点击这里查看](https://github.com/doocs/advanced-java/blob/master/docs/high-concurrency/how-to-ensure-high-availability-of-message-queues.md)。
- 系统复杂度提高
  硬生生加个 MQ 进来，你怎么[保证消息没有重复消费](https://github.com/doocs/advanced-java/blob/master/docs/high-concurrency/how-to-ensure-that-messages-are-not-repeatedly-consumed.md)？怎么[处理消息丢失的情况](https://github.com/doocs/advanced-java/blob/master/docs/high-concurrency/how-to-ensure-the-reliable-transmission-of-messages.md)？怎么保证消息传递的顺序性？头大头大，问题一大堆，痛苦不已。
- 一致性问题
  A 系统处理完了直接返回成功了，人都以为你这个请求就成功了；但是问题是，要是 BCD 三个系统那里，BD 两个系统写库成功了，结果 C 系统写库失败了，咋整？你这数据就不一致了。

### Kafka、ActiveMQ、RabbitMQ、RocketMQ 有什么优缺点？

| 特性                     | ActiveMQ                              | RabbitMQ                                           | RocketMQ                                                     | Kafka                                                        |
| ------------------------ | ------------------------------------- | -------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 单机吞吐量               | 万级，比 RocketMQ、Kafka 低一个数量级 | 同 ActiveMQ                                        | 10 万级，支撑高吞吐                                          | 10 万级，高吞吐，一般配合大数据类的系统来进行实时数据计算、日志采集等场景 |
| topic 数量对吞吐量的影响 |                                       |                                                    | topic 可以达到几百/几千的级别，吞吐量会有较小幅度的下降，这是 RocketMQ 的一大优势，在同等机器下，可以支撑大量的 topic | topic 从几十到几百个时候，吞吐量会大幅度下降，在同等机器下，Kafka 尽量保证 topic 数量不要过多，如果要支撑大规模的 topic，需要增加更多的机器资源 |
| 时效性                   | ms 级                                 | 微秒级，这是 RabbitMQ 的一大特点，延迟最低         | ms 级                                                        | 延迟在 ms 级以内                                             |
| 可用性                   | 高，基于主从架构实现高可用            | 同 ActiveMQ                                        | 非常高，分布式架构                                           | 非常高，分布式，一个数据多个副本，少数机器宕机，不会丢失数据，不会导致不可用 |
| 消息可靠性               | 有较低的概率丢失数据                  | 基本不丢                                           | 经过参数优化配置，可以做到 0 丢失                            | 同 RocketMQ                                                  |
| 功能支持                 | MQ 领域的功能极其完备                 | 基于 erlang 开发，并发能力很强，性能极好，延时很低 | MQ 功能较为完善，还是分布式的，扩展性好                      | 功能较为简单，主要支持简单的 MQ 功能，在大数据领域的实时计算以及日志采集被大规模使用 |

考虑一下你负责的系统中是否有类似的场景，就是一个系统或者一个模块，调用了多个系统或者模块，互相之间的调用很复杂，维护起来很麻烦。但是其实这个调用是不需要直接同步调用接口的，如果用 MQ 给它异步化解耦，也是可以的，你就需要去考虑在你的项目里，是不是可以运用这个 MQ 去进行系统的解耦。在简历中体现出来这块东西，用 MQ 作解耦。 

## 数据库:

### 索引:

#### 为什么要使用索引?

通过创建唯一性索引,可以保证数据库表中每一行数据的唯一性. 可以大大的提高数据检索速度(大大减少检索的数据量), 这也是创建索引的最主要的原因.帮助服务器避免排序和临时表, 将随机IO变为顺序IO, 可以加快表和表之间的联系.

#### 索引这么多有点,为什么不对表中的每一个列创建一个索引?

当对表中的数据量进行增加,删除,和修改的时候,索引也要动态的维护,这样就降低了数据的维护速度. 索引需要占物理空间,除了数据表占数据空间之外,每一个索引还要占一定的物理空间, 如果要建立聚簇索引,那么需要的空间就会更大. 创建索引和维护索引要耗费时间,这种时间随着数据量的增加而增加.

索引是如何提高查询速度的?

将无序的数据变成相对有序的数据(像查目录一样)

#### 使用索引注意事项:

在经常需要检索的列上,可以加快搜索的速度; 在经常使用的在where子句中的列上面创建索引,加快条件的判断速度.在经常需要排序的列上创建索引,因为索引已经排序,这样查询可以利用索引的排序,加快排序查询时间;对于中型大型表索引有效,特大型的表需要大的开销维护, 不适合建立索引; 在经常用的在连接的列上,这些列主要是一些外键,可以加快连接的速度;避免where载具中对字段施加函数,会造成无法命中索引;在使用InnoDB时使用与业务无关的自增主键作为主键,即使用逻辑主键,为不是用业务主键.将打算加索引的列设置为NOT NULL,否则将导致引擎放弃使用索引而进行全表扫描;删除长期未使用的索引,不同的索引的存在会造成不必要的性能损耗MySQL5.7可以通过查询sys库的schema_unused_indexes 视图来查询哪些索引从未被使用在使用limit offset查询缓慢时,可以借助索引提高性能.

Mysql索引主要使用的两种数据结构.

哈希索引:对于哈希索引来说,底层的数据结构就是哈希表.因此在绝大多数需求为单条记录查询的时候,可以选择哈希索引,查询性能最快, 其余大部分场景建议选择BTree索引.

BTree索引:Mysql的BTree索引使用的是B树中的B+Tree.但对于主要的两种存储引擎(MylSAM和InnoDB)的实现方式是不同的.

#### MyISAM和InnoDB实现BTree索引方式的区别:

MyISAM:B+Tree叶节点的data域存放的是数据记录的地址.在索引检索的时候,首先按照B+Tree搜索算法搜索引擎

InnoDB:其数据文件本身就是索引文件,相比MyISAM,索引文件和数据文件是分离的,其表数据文件本身就是按B+Tree组织的一个索引结构,树的叶节点data域保存了完整的数据记录.这个索引的key是数据表的主键,因此InnoDB表数据文件本身就是朱索引.这被称为聚簇索引(聚集索引)

#### 分库分表：

| #            | 分库分表前                   | 分库分表后                                   |
| ------------ | ---------------------------- | -------------------------------------------- |
| 并发支撑情况 | MySQL 单机部署，扛不住高并发 | MySQL从单机到多机，能承受的并发增加了多倍    |
| 磁盘使用情况 | MySQL 单机磁盘容量几乎撑满   | 拆分为多个库，数据库服务器磁盘使用率大大降低 |
| SQL 执行性能 | 单表数据量太大，SQL 越跑越慢 | 单表数据量减少，SQL 执行效率明显提升         |

分库分表中间件：

Sharding-jdbc 这种 client 层方案的**优点在于不用部署，运维成本低，不需要代理层的二次转发请求，性能很高**，但是如果遇到升级啥的需要各个系统都重新升级版本再发布，各个系统都需要**耦合** Sharding-jdbc 的依赖；

Mycat 这种 proxy 层方案的**缺点在于需要部署**，自己运维一套中间件，运维成本高，但是**好处在于对于各个项目是透明的**，如果遇到升级之类的都是自己中间件那里搞就行了。

**水平拆分**的意思，就是把一个表的数据给弄到多个库的多个表里去，但是每个库的表结构都一样，只不过每个库表放的数据是不同的，所有库表的数据加起来就是全部数据。水平拆分的意义，就是将数据均匀放更多的库里，然后用多个库来扛更高的并发，还有就是用多个库的存储容量来进行扩容 。

**垂直拆分**的意思，就是**把一个有很多字段的表给拆分成多个表**，**或者是多个库上去**。每个库表的结构都不一样，每个库表都包含部分字段。一般来说，会**将较少的访问频率很高的字段放到一个表里去**，然后**将较多的访问频率很低的字段放到另外一个表里去**。因为数据库是有缓存的，你访问频率高的行字段越少，就可以在缓存里缓存更多的行，性能就越好。这个一般在表层面做的较多一些。 

#### 购物车逻辑:

1. 不和数据库交互
2. 点击添加购物车按钮; 用户id和商品信息存在redis中, 本地Cookie添加商品信息
3. 其他设备登录 先从Cookie中查找购物车商品记录 如果没有 发送请求到后台去redis中查询
4. 点击结算    购物车和cookie中的相应商品移除

# Java 8 新特性

- **Lambda 表达式** − Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中。
- **方法引用** − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
- **默认方法** − 默认方法就是一个在接口里面有了一个实现的方法。
- **新工具** − 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
- **Stream API** −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
- **Date Time API** − 加强对日期与时间的处理。
- **Optional 类** − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
- **Nashorn, JavaScript 引擎** − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。

## 多线程:

#### 1) 什么是线程？

线程是操作系统能够进行运算调度的最小单位，它被包含在进程之中，是进程中的实际运作单位。程序员可以通过它进行多处理器编程，你可以使用多线程对运算密集型任务提速。比如，如果一个线程完成一个任务要100毫秒，那么用十个线程完成该任务只需10毫秒。

#### 2) 线程和进程有什么区别？

一个进程是一个独立(self contained)的运行环境，它可以被看作一个程序或者一个应用。而线程是在进程中执行的一个任务。线程是进程的子集，一个进程可以有很多线程，每条线程并行执行不同的任务。不同的进程使用不同的内存空间，而所有的线程共享一片相同的内存空间。别把它和栈内存搞混，每个线程都拥有单独的栈内存用来存储本地数据。

#### 3) 如何在Java中实现线程？

有两种创建线程的方法：一是实现Runnable接口，然后将它传递给Thread的构造函数，创建一个Thread对象；二是直接继承Thread类。

#### 4) 用Runnable还是Thread？

这个问题是上题的后续，大家都知道我们可以通过继承Thread类或者调用Runnable接口来实现线程，问题是，那个方法更好呢？什么情况下使用它？这个问题很容易回答，如果你知道Java不支持类的多重继承，但允许你调用多个接口。所以如果你要继承其他类，当然是调用Runnable接口好了。更多详细信息请点击这里。

#### 6) Thread 类中的start() 和 run() 方法有什么区别？

start()方法被用来启动新创建的线程，使该被创建的线程状态变为可运行状态。当你调用run()方法的时候，只会是在原来的线程中调用，没有新的线程启动，start()方法才会启动新线程。如果我们调用了Thread的run()方法，它的行为就会和普通的方法一样，直接运行run（）方法。为了在新的线程中执行我们的代码，必须使用Thread.start()方法。

#### 7) Java中Runnable和Callable有什么不同？

Runnable和Callable都代表那些要在不同的线程中执行的任务。Runnable从JDK1.0开始就有了，Callable是在JDK1.5增加的。它们的主要区别是Callable的 call() 方法可以返回值和抛出异常，而Runnable的run()方法没有这些功能。Callable可以返回装载有计算结果的Future对象。

#### 8) Java中CyclicBarrier 和 CountDownLatch有什么不同？

CyclicBarrier 和 CountDownLatch 都可以用来让一组线程等待其它线程。与 CyclicBarrier 不同的是，CountdownLatch 不能重新使用。

#### 9) Java内存模型是什么？

Java内存模型规定和指引Java程序在不同的内存架构、CPU和操作系统间有确定性地行为。它在多线程的情况下尤其重要。Java内存模型对一个线程所做的变动能被其它线程可见提供了保证，它们之间是先行发生关系。这个关系定义了一些规则让程序员在并发编程时思路更清晰。比如，先行发生关系确保了：

- 线程内的代码能够按先后顺序执行，这被称为程序次序规则。
- 对于同一个锁，一个解锁操作一定要发生在时间上后发生的另一个锁定操作之前，也叫做管程锁定规则。
- 前一个对volatile的写操作在后一个volatile的读操作之前，也叫volatile变量规则。
- 一个线程内的任何操作必需在这个线程的start()调用之后，也叫作线程启动规则。
- 一个线程的所有操作都会在线程终止之前，线程终止规则。
- 一个对象的终结操作必需在这个对象构造完成之后，也叫对象终结规则。
- 可传递性

#### 10) 什么是线程安全？Vector是一个线程安全类吗？

如果你的代码所在的进程中有多个线程在同时运行，而这些线程可能会同时运行这段代码。如果每次运行结果和单线程运行的结果是一样的，而且其他的变量的值也和预期的是一样的，就是线程安全的。一个线程安全的计数器类的同一个实例对象在被多个线程使用的情况下也不会出现计算失误。很显然你可以将集合类分成两组，线程安全和非线程安全的。Vector 是用同步方法来实现线程安全的, 而和它相似的ArrayList不是线程安全的。

#### 12) Java中什么是竞态条件？

在大多数实际的多线程应用中，两个或两个以上的线程需要共享对同一数据的存取。如果i线程存取相同的对象，并且每一个线程都调用了一个修改该对象状态的方法，将会发生什么呢？可以想象，线程彼此踩了对方的脚。根据线程访问数据的次序，可能会产生讹误的对象。这样的情况通常称为竞争条件。

#### 13) Java中如何停止一个线程？

Java提供了很丰富的API但没有为停止线程提供API。JDK 1.0本来有一些像stop(), suspend() 和 resume()的控制方法，但是由于潜在的死锁威胁。因此在后续的JDK版本中他们被弃用了，之后Java API的设计者就没有提供一个兼容且线程安全的方法来停止一个线程。当run() 或者 call() 方法执行完的时候线程会自动结束，如果要手动结束一个线程，可以用volatile 布尔变量来退出run()方法的循环或者是取消任务来中断线程。

#### 14) 一个线程运行时发生异常会怎样？

如果异常没有被捕获该线程将会停止执行。Thread.UncaughtExceptionHandler是用于处理未捕获异常造成线程突然中断情况的一个内嵌接口。当一个未捕获异常将造成线程中断的时候JVM会使用Thread.getUncaughtExceptionHandler()来查询线程的UncaughtExceptionHandler并将线程和异常作为参数传递给handler的uncaughtException()方法进行处理。

#### 15） 如何在两个线程间共享数据？

你可以通过共享对象来实现这个目的，或者是使用像阻塞队列这样并发的数据结构。这篇教程《Java线程间通信》(涉及到在两个线程间共享对象)用wait和notify方法实现了生产者消费者模型。

#### 16) Java中notify 和 notifyAll有什么区别？

这又是一个刁钻的问题，因为多线程可以等待单监控锁，Java API 的设计人员提供了一些方法当等待条件改变的时候通知它们，但是这些方法没有完全实现。notify()方法不能唤醒某个具体的线程，所以只有一个线程在等待的时候它才有用武之地。而notifyAll()唤醒所有线程并允许他们争夺锁确保了至少有一个线程能继续运行。

#### 17) 为什么wait, notify 和 notifyAll这些方法不在thread类里面？

一个很明显的原因是JAVA提供的锁是对象级的而不是线程级的，每个对象都有锁，通过线程获得。如果线程需要等待某些锁那么调用对象中的wait()方法就有意义了。如果wait()方法定义在Thread类中，线程正在等待的是哪个锁就不明显了。简单的说，由于wait，notify和notifyAll都是锁级别的操作，所以把他们定义在Object类中因为锁属于对象。

#### 18) 什么是ThreadLocal变量？

ThreadLocal是Java里一种特殊的变量。每个线程都有一个ThreadLocal就是每个线程都拥有了自己独立的一个变量，竞争条件被彻底消除了。如果为每个线程提供一个自己独有的变量拷贝，将大大提高效率。首先，通过复用减少了代价高昂的对象的创建个数。其次，你在没有使用高代价的同步或者不变性的情况下获得了线程安全。

#### 19) 什么是FutureTask？

在Java并发程序中FutureTask表示一个可以取消的异步运算。它有启动和取消运算、查询运算是否完成和取回运算结果等方法。只有当运算完成的时候结果才能取回，如果运算尚未完成get方法将会阻塞。一个FutureTask对象可以对调用了Callable和Runnable的对象进行包装，由于FutureTask也是调用了Runnable接口所以它可以提交给Executor来执行。

#### 20) Java中interrupted 和 isInterruptedd方法的区别？

interrupted() 和 isInterrupted()的主要区别是前者会将中断状态清除而后者不会。Java多线程的中断机制是用内部标识来实现的，调用Thread.interrupt()来中断一个线程就会设置中断标识为true。当中断线程调用静态方法Thread.interrupted()来检查中断状态时，中断状态会被清零。而非静态方法isInterrupted()用来查询其它线程的中断状态且不会改变中断状态标识。简单的说就是任何抛出InterruptedException异常的方法都会将中断状态清零。无论如何，一个线程的中断状态有有可能被其它线程调用中断来改变。

#### 21) 为什么wait和notify方法要在同步块中调用？

当一个线程需要调用对象的wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的notify()方法。同样的，当一个线程需要调用对象的notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。如果你不这么做，代码会抛出IllegalMonitorStateException异常。

#### 22) 为什么你应该在循环中检查等待条件?

处于等待状态的线程可能会收到错误警报和伪唤醒，如果不在循环中检查等待条件，程序就会在没有满足结束条件的情况下退出。因此，当一个等待线程醒来时，不能认为它原来的等待状态仍然是有效的，在notify()方法调用之后和等待线程醒来之前这段时间它可能会改变。这就是在循环中使用wait()方法效果更好的原因，你可以在Eclipse中创建模板调用wait和notify试一试。如果你想了解更多关于这个问题的内容，推荐你阅读《Effective Java》这本书中的线程和同步章节。

#### 23) Java中的同步集合与并发集合有什么区别？

同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。在Java1.5之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。Java5介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和内部分区等现代技术提高了可扩展性。更多内容详见答案。

#### 24） Java中堆和栈有什么不同？

为什么把这个问题归类在多线程和并发面试题里？因为栈是一块和线程紧密相关的内存区域。每个线程都有自己的栈内存，用于存储本地变量，方法参数和栈调用，一个线程中存储的变量对其它线程是不可见的。而堆是所有线程共享的一片公用内存区域。对象都在堆里创建，为了提升效率线程会从堆中弄一个缓存到自己的栈，如果多个线程使用该变量就可能引发问题，这时volatile 变量就可以发挥作用了，它要求线程从主存中读取变量的值。

#### 25） 什么是线程池？ 为什么要使用它？

创建线程要花费昂贵的资源和时间，如果任务来了才创建线程那么响应时间会变长，而且一个进程能创建的线程数有限。为了避免这些问题，在程序启动的时候就创建若干线程来响应处理，它们被称为线程池，里面的线程叫工作线程。从JDK1.5开始，Java API提供了Executor框架让你可以创建不同的线程池。比如单线程池，每次处理一个任务；数目固定的线程池或者是缓存线程池（一个适合很多生存期短的任务的程序的可扩展线程池）。

#### 26） 如何写代码来解决生产者消费者问题？

在现实中你解决的许多线程问题都属于生产者消费者模型，就是一个线程生产任务供其它线程进行消费，你必须知道怎么进行线程间通信来解决这个问题。比较低级的办法是用wait和notify来解决这个问题，比较赞的办法是用Semaphore 或者 BlockingQueue来实现生产者消费者模型。

#### 27） 如何避免死锁？

Java多线程中的死锁

死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象，若无外力作用，它们都将无法推进下去。这是一个严重的问题，因为死锁会让你的程序挂起无法完成任务，死锁的发生必须满足以下四个条件：

- 互斥条件：一个资源每次只能被一个进程使用。
- 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
- 不剥夺条件：进程已获得的资源，在末使用完之前，不能强行剥夺。
- 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。

避免死锁最简单的方法就是阻止循环等待条件，将系统中所有的资源设置标志位、排序，规定所有的进程申请资源必须以一定的顺序（升序或降序）做操作来避免死锁。

#### 28) Java中活锁和死锁有什么区别？

这是上题的扩展，活锁和死锁类似，不同之处在于处于活锁的线程或进程的状态是不断改变的，活锁可以认为是一种特殊的饥饿。一个现实的活锁例子是两个人在狭小的走廊碰到，两个人都试着避让对方好让彼此通过，但是因为避让的方向都一样导致最后谁都不能通过走廊。简单的说就是，活锁和死锁的主要区别是前者进程的状态可以改变但是却不能继续执行。

#### 29） 怎么检测一个线程是否拥有锁？

在java.lang.Thread中有一个方法叫holdsLock()，它返回true如果当且仅当当前线程拥有某个具体对象的锁。

#### 30) 你如何在Java中获取线程堆栈？

对于不同的操作系统，有多种方法来获得Java进程的线程堆栈。当你获取线程堆栈时，JVM会把所有线程的状态存到日志文件或者输出到控制台。在Windows你可以使用Ctrl + Break组合键来获取线程堆栈，Linux下用kill -3命令。你也可以用jstack这个工具来获取，它对线程id进行操作，你可以用jps这个工具找到id。

#### 31) JVM中哪个参数是用来控制线程的栈堆栈小的

这个问题很简单， -Xss参数用来控制线程的堆栈大小。你可以查看JVM配置列表来了解这个参数的更多信息。

#### 32） Java中synchronized 和 ReentrantLock 有什么不同？

Java在过去很长一段时间只能通过synchronized关键字来实现互斥，它有一些缺点。比如你不能扩展锁之外的方法或者块边界，尝试获取锁时不能中途取消等。Java 5 通过Lock接口提供了更复杂的控制来解决这些问题。 ReentrantLock 类实现了 Lock，它拥有与 synchronized 相同的并发性和内存语义且它还具有可扩展性。

#### 33） 有三个线程T1，T2，T3，怎么确保它们按顺序执行（确保main()方法所在的线程是Java程序最后结束的线程）？

在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，另外一个线程完成该线程继续执行。为了确保三个线程的顺序你应该先启动最后一个(T3调用T2，T2调用T1)，这样T1就会先完成而T3最后完成。

#### 34) Thread类中的yield方法有什么作用？

yield方法可以暂停当前正在执行的线程对象，让其它有相同优先级的线程执行。它是一个静态方法而且只保证当前线程放弃CPU占用而不能保证使其它线程一定能占用CPU，执行yield()的线程有可能在进入到暂停状态后马上又被执行。点击这里查看更多yield方法的相关内容。	

#### 35） Java中ConcurrentHashMap的并发度是什么？

ConcurrentHashMap把实际map划分成若干部分来实现它的可扩展性和线程安全。这种划分是使用并发度获得的，它是ConcurrentHashMap类构造函数的一个可选参数，默认值为16，这样在多线程情况下就能避免争用。

#### 36） Java中Semaphore是什么？

Java中的Semaphore是一种新的同步类，它是一个计数信号。从概念上讲，从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release()添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore只对可用许可的号码进行计数，并采取相应的行动。信号量常常用于多线程的代码中，比如数据库连接池。更多详细信息请点击这里。

#### 37）如果你提交任务时，线程池队列已满。会时发会生什么？

这个问题问得很狡猾，许多程序员会认为该任务会阻塞直到线程池队列有空位。事实上如果一个任务不能被调度执行那么ThreadPoolExecutor’s submit()方法将会抛出一个RejectedExecutionException异常。

#### 38) Java线程池中submit() 和 execute()方法有什么区别？

两个方法都可以向线程池提交任务，execute()方法的返回类型是void，它定义在Executor接口中, 而submit()方法可以返回持有计算结果的Future对象，它定义在ExecutorService接口中，它扩展了Executor接口，其它线程池类像ThreadPoolExecutor和ScheduledThreadPoolExecutor都有这些方法。更多详细信息请点击这里。

#### 39) 什么是阻塞式方法？

阻塞式方法是指程序会一直等待该方法完成期间不做其他事情，ServerSocket的accept()方法就是一直等待客户端连接。这里的阻塞是指调用结果返回之前，当前线程会被挂起，直到得到结果之后才会返回。此外，还有异步和非阻塞式方法在任务完成前就返回。更多详细信息请点击这里。

#### 40） 你对线程优先级的理解是什么？

每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OS dependent)。我们可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个int变量(从1-10)，1代表最低优先级，10代表最高优先级。

#### 41） 什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing)？

线程调度器是一个操作系统服务，它负责为Runnable状态的线程分配CPU时间。一旦我们创建一个线程并启动它，它的执行便依赖于线程调度器的实现。时间分片是指将可用的CPU时间分配给可用的Runnable线程的过程。分配CPU时间可以基于线程优先级或者线程等待的时间。线程调度并不受到Java虚拟机控制，所以由应用程序来控制它是更好的选择（也就是说不要让你的程序依赖于线程的优先级）。

#### 42） 在多线程中，什么是上下文切换(context-switching)？

上下文切换是存储和恢复CPU状态的过程，它使得线程执行能够从中断点恢复执行。上下文切换是多任务操作系统和多线程环境的基本特征。

#### 43) 如何在Java中创建Immutable对象？

Immutable对象可以在没有同步的情况下共享，降低了对该对象进行并发访问时的同步化开销。要创建不可变类，要实现下面几个步骤：通过构造方法初始化所有成员、对变量不要提供setter方法、将所有的成员声明为私有的，这样就不允许直接访问这些成员、在getter方法中，不要直接返回对象本身，而是克隆对象，并返回对象的拷贝。

#### 44） Java中的ReadWriteLock是什么？

一般而言，读写锁是用来提升并发程序性能的锁分离技术的成果。Java中的ReadWriteLock是Java 5 中新增的一个接口，一个ReadWriteLock维护一对关联的锁，一个用于只读操作一个用于写。在没有写线程的情况下一个读锁可能会同时被多个读线程持有。写锁是独占的，你可以使用JDK中的ReentrantReadWriteLock来实现这个规则，它最多支持65535个写锁和65535个读锁。

#### 45) 多线程中的忙循环是什么?

忙循环就是程序员用循环让一个线程等待，不像传统方法wait(), sleep() 或 yield() 它们都放弃了CPU控制，而忙循环不会放弃CPU，它就是在运行一个空循环。这么做的目的是为了保留CPU缓存，在多核系统中，一个等待线程醒来的时候可能会在另一个内核运行，这样会重建缓存。为了避免重建缓存和减少等待重建的时间就可以使用它了。

#### 46）volatile 变量和 atomic 变量有什么不同？

这是个有趣的问题。首先，volatile 变量和 atomic 变量看起来很像，但功能却不一样。Volatile变量可以确保先行关系，即写操作会发生在后续的读操作之前, 但它并不能保证原子性。例如用volatile修饰count变量那么 count++ 操作就不是原子性的。而AtomicInteger类提供的atomic方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作。

#### 47) 如果同步块内的线程抛出异常会发生什么？

这个问题坑了很多Java程序员，若你能想到锁是否释放这条线索来回答还有点希望答对。无论你的同步块是正常还是异常退出的，里面的线程都会释放锁，所以对比锁接口我们更喜欢同步块，因为它不用花费精力去释放锁，该功能可以在finally block里释放锁实现。

#### 48） 单例模式的双检锁是什么？

这个问题在Java面试中经常被问到，但是面试官对回答此问题的满意度仅为50%。一半的人写不出双检锁还有一半的人说不出它的隐患和Java1.5是如何对它修正的。它其实是一个用来创建线程安全的单例的老方法，当单例实例第一次被创建时它试图用单个锁进行性能优化，但是由于太过于复杂在JDK1.4中它是失败的。

#### 49） 如何在Java中创建线程安全的Singleton？

这是上面那个问题的后续，如果你不喜欢双检锁而面试官问了创建Singleton类的替代方法，你可以利用JVM的类加载和静态变量初始化特征来创建Singleton实例，或者是利用枚举类型来创建Singleton。

#### 50) 写出3条你遵循的多线程最佳实践

以下三条最佳实践大多数Java程序员都应该遵循：

- 给你的线程起个有意义的名字。

这样可以方便找bug或追踪。OrderProcessor, QuoteProcessor or TradeProcessor 这种名字比 Thread-1. Thread-2 and Thread-3 好多了，给线程起一个和它要完成的任务相关的名字，所有的主要框架甚至JDK都遵循这个最佳实践。

- 避免锁定和缩小同步的范围

锁花费的代价高昂且上下文切换更耗费时间空间，试试最低限度的使用同步和锁，缩小临界区。因此相对于同步方法我更喜欢同步块，它给我拥有对锁的绝对控制权。

- 多用同步类少用wait 和 notify

首先，CountDownLatch, Semaphore, CyclicBarrier 和 Exchanger 这些同步类简化了编码操作，而用wait和notify很难实现对复杂控制流的控制。其次，这些类是由最好的企业编写和维护在后续的JDK中它们还会不断优化和完善，使用这些更高等级的同步工具你的程序可以不费吹灰之力获得优化。

- 多用并发集合少用同步集合

这是另外一个容易遵循且受益巨大的最佳实践，并发集合比同步集合的可扩展性更好，所以在并发编程时使用并发集合效果更好。如果下一次你需要用到map，你应该首先想到用ConcurrentHashMap。

#### 51) 如何强制启动一个线程？

这个问题就像是如何强制进行Java垃圾回收，目前还没有觉得方法，虽然你可以使用System.gc()来进行垃圾回收，但是不保证能成功。在Java里面没有办法强制启动一个线程，它是被线程调度器控制着且Java没有公布相关的API。

#### 52) Java中的fork join框架是什么？

fork join框架是JDK7中出现的一款高效的工具，Java开发人员可以通过它充分利用现代服务器上的多处理器。它是专门为了那些可以递归划分成许多子模块设计的，目的是将所有可用的处理能力用来提升程序的性能。fork join框架一个巨大的优势是它使用了工作窃取算法，可以完成更多任务的工作线程可以从其它线程中窃取任务来执行。

#### 53） Java多线程中调用wait() 和 sleep()方法有什么不同？

Java程序中wait 和 sleep都会造成某种形式的暂停，它们可以满足不同的需要。wait()方法用于线程间通信，如果等待条件为真且其它线程被唤醒时它会释放锁，而sleep()方法仅仅释放CPU资源或者让当前线程停止执行一段时间，但不会释放锁。需要注意的是，sleep（）并不会让线程终止，一旦从休眠中唤醒线程，线程的状态将会被改变为Runnable，并且根据线程调度，它将得到执行。

#### 54） 什么是Thread Group？为什么不建议使用它？

ThreadGroup是一个类，它的目的是提供关于线程组的信息。

ThreadGroup API比较薄弱，它并没有比Thread提供了更多的功能。它有两个主要的功能：一是获取线程组中处于活跃状态线程的列表；二是设置为线程设置未捕获异常处理器(ncaught exception handler)。但在Java 1.5中Thread类也添加了setUncaughtExceptionHandler(UncaughtExceptionHandler eh) 方法，所以ThreadGroup是已经过时的，不建议继续使用。

#### 55) 什么是Java线程转储(Thread Dump)，如何得到它？

线程转储是一个JVM活动线程的列表，它对于分析系统瓶颈和死锁非常有用。有很多方法可以获取线程转储——使用Profiler，Kill -3命令，jstack工具等等。我们更喜欢jstack工具，因为它容易使用并且是JDK自带的。由于它是一个基于终端的工具，所以我们可以编写一些脚本去定时的产生线程转储以待分析。

#### 56) 什么是Java Timer类？如何创建一个有特定时间间隔的任务？

java.util.Timer是一个工具类，可以用于安排一个线程在未来的某个特定时间执行。Timer类可以用安排一次性任务或者周期任务。

java.util.TimerTask是一个实现了Runnable接口的抽象类，我们需要去继承这个类来创建我们自己的定时任务并使用Timer去安排它的执行。

#### 57) 什么是原子操作？在Java Concurrency API中有哪些原子类(atomic classes)？

原子操作是指一个不受其他操作影响的操作任务单元。原子操作是在多线程环境下避免数据不一致必须的手段。

int++并不是一个原子操作，所以当一个线程读取它的值并加1时，另外一个线程有可能会读到之前的值，这就会引发错误。

在 java.util.concurrent.atomic 包中添加原子变量类之后，这种情况才发生了改变。所有原子变量类都公开比较并设置原语（与比较并交换类似），这些原语都是使用平台上可用的最快本机结构（比较并交换、加载链接/条件存储，最坏的情况下是旋转锁）来实现的。 java.util.concurrent.atomic 包中提供了原子变量的 9 种风格（ AtomicInteger； AtomicLong； AtomicReference； AtomicBoolean；原子整型；长型；引用；及原子标记引用和戳记引用类的数组形式，其原子地更新一对值）。

#### 58） Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？

Lock接口比同步方法和同步块提供了更具扩展性的锁操作。他们允许更灵活的结构，可以具有完全不同的性质，并且可以支持多个相关类的条件对象。

它的优势有：

- 可以使锁更公平
- 可以使线程在等待锁的时候响应中断
- 可以让线程尝试获取锁，并在无法获取锁的时候立即返回或者等待一段时间
- 可以在不同的范围，以不同的顺序获取和释放锁

#### 59） 什么是Executor框架？

Executor框架同java.util.concurrent.Executor 接口在Java 5中被引入。Executor框架是一个根据一组执行策略调用，调度，执行和控制的异步任务的框架。

无限制的创建线程会引起应用程序内存溢出。所以创建一个线程池是个更好的的解决方案，因为可以限制线程的数量并且可以回收再利用这些线程。利用Executor框架可以非常方便的创建一个线程池。

#### 60） Executors类是什么？

Executors为Executor，ExecutorService，ScheduledExecutorService，ThreadFactory和Callable类提供了一些工具方法。

Executors可以用于方便的创建线程池。

#### 61） 什么是阻塞队列？如何使用阻塞队列来实现生产者-消费者模型？

java.util.concurrent.BlockingQueue的特性是：当队列是空的时，从队列中获取或删除元素的操作将会被阻塞，或者当队列是满时，往队列里添加元素的操作会被阻塞。

阻塞队列不接受空值，当你尝试向队列中添加空值的时候，它会抛出NullPointerException。

阻塞队列的实现都是线程安全的，所有的查询方法都是原子的并且使用了内部锁或者其他形式的并发控制。

BlockingQueue 接口是java collections框架的一部分，它主要用于实现生产者-消费者问题。

#### 62）什么是Callable和Future?

Java 5在concurrency包中引入了java.util.concurrent.Callable 接口，它和Runnable接口很相似，但它可以返回一个对象或者抛出一个异常。

Callable接口使用泛型去定义它的返回类型。Executors类提供了一些有用的方法去在线程池中执行Callable内的任务。由于Callable任务是并行的，我们必须等待它返回的结果。java.util.concurrent.Future对象为我们解决了这个问题。在线程池提交Callable任务后返回了一个Future对象，使用它我们可以知道Callable任务的状态和得到Callable返回的执行结果。Future提供了get()方法让我们可以等待Callable结束并获取它的执行结果。

#### 63） 什么是FutureTask?

FutureTask包装器是一种非常便利的机制，可将Callable转换成Future和Runnable，它同时实现两者的接口。

FutureTask类是Future 的一个实现，并实现了Runnable，所以可通过Excutor(线程池) 来执行。也可传递给Thread对象执行。如果在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，当主线程将来需要时，就可以通过Future对象获得后台作业的计算结果或者执行状态。

#### 64） 什么是并发容器的实现？

Java集合类都是快速失败的，这就意味着当集合被改变且一个线程在使用迭代器遍历集合的时候，迭代器的next()方法将抛出ConcurrentModificationException异常。

并发容器：并发容器是针对多个线程并发访问设计的，在jdk5.0引入了concurrent包，其中提供了很多并发容器，如ConcurrentHashMap，CopyOnWriteArrayList等。并发容器使用了与同步容器完全不同的加锁策略来提供更高的并发性和伸缩性，例如在ConcurrentHashMap中采用了一种粒度更细的加锁机制，可以称为分段锁，在这种锁机制下，允许任意数量的读线程并发地访问map，并且执行读操作的线程和写操作的线程也可以并发的访问map，同时允许一定数量的写操作线程并发地修改map，所以它可以在并发环境下实现更高的吞吐量。

#### 65）用户线程和守护线程有什么区别？

当我们在Java程序中创建一个线程，它就被称为用户线程。一个守护线程是在后台执行并且不会阻止JVM终止的线程。当没有用户线程在运行的时候，JVM关闭程序并且退出。一个守护线程创建的子线程依然是守护线程。

#### 66）有哪些不同的线程生命周期？

当我们在Java程序中新建一个线程时，它的状态是New。当我们调用线程的start()方法时，状态被改变为Runnable。线程调度器会为Runnable线程池中的线程分配CPU时间并且讲它们的状态改变为Running。其他的线程状态还有Waiting，Blocked 和Dead。

#### 67）线程之间是如何通信的？

当线程间是可以共享资源时，线程间通信是协调它们的重要的手段。Object类中wait()\notify()\notifyAll()方法可以用于线程间通信关于资源的锁的状态。

#### 68）为什么Thread类的sleep()和yield()方法是静态的？

Thread类的sleep()和yield()方法将在当前正在执行的线程上运行。所以在其他处于等待状态的线程上调用这些方法是没有意义的。这就是为什么这些方法是静态的。它们可以在当前正在执行的线程中工作，并避免程序员错误的认为可以在其他非运行线程调用这些方法。

#### 69）如何确保线程安全？

在Java中可以有很多方法来保证线程安全——同步，使用原子类(atomic concurrent classes)，实现并发锁，使用volatile关键字，使用不变类和线程安全类。

#### 70）同步方法和同步块，哪个是更好的选择？

同步块是更好的选择，因为它不会锁住整个对象（当然你也可以让它锁住整个对象）。同步方法会锁住整个对象，哪怕这个类中有多个不相关联的同步块，这通常会导致他们停止执行并需要等待获得这个对象上的锁。

#### 71）如何创建守护线程？

使用Thread类的setDaemon(true)方法可以将线程设置为守护线程，需要注意的是，需要在调用start()方法前调用这个方法，否则会抛出IllegalThreadStateException异常。

#### 72）线程调度策略？

(1) 抢占式调度策略

Java运行时系统的线程调度算法是抢占式的 (preemptive)。Java运行时系统支持一种简单的固定优先级的调度算法。如果一个优先级比其他任何处于可运行状态的线程都高的线程进入就绪状态，那么运行时系统就会选择该线程运行。新的优先级较高的线程抢占(preempt)了其他线程。但是Java运行时系统并不抢占同优先级的线程。换句话说，Java运行时系统不是分时的(time-slice)。然而，基于Java Thread类的实现系统可能是支持分时的，因此编写代码时不要依赖分时。当系统中的处于就绪状态的线程都具有相同优先级时，线程调度程序采用一种简单的、非抢占式的轮转的调度顺序。

(2) 时间片轮转调度策略

有些系统的线程调度采用时间片轮转(round-robin)调度策略。这种调度策略是从所有处于就绪状态的线程中选择优先级最高的线程分配一定的CPU时间运行。该时间过后再选择其他线程运行。只有当线程运行结束、放弃(yield)CPU或由于某种原因进入阻塞状态，低优先级的线程才有机会执行。如果有两个优先级相同的线程都在等待CPU，则调度程序以轮转的方式选择运行的线程。

#### 73) 在线程中你怎么处理不可捕捉异常？

Thread.UncaughtExceptionHandler是java SE5中的新接口，它允许我们在每一个Thread对象上添加一个异常处理器。

## 网络相关:

#### DNS：

**DNS** 是计算机域名系统 (Domain Name System 或Domain Name Service) 的缩写，由解析器和域名服务器组成的。

域名服务器是指保存有该网络中所有主机的域名和对应IP地址，并具有将域名转换为IP地址功能的服务器。

一般一个域名的 DNS解析时间 在10~60毫秒之间。

> 一个域名必须对应一个IP地址，而一个IP地址不一定会有域名。

#### HTTP和HTTPS

**HTTP协议**（HyperText Transfer Protocol，超文本传输协议）：是一种发布和接收 HTML页面的方法。

**HTTPS**（Hypertext Transfer Protocol over Secure Socket Layer）简单讲是HTTP的安全版，在HTTP下加入SSL层。

**SSL**（Secure Sockets Layer 安全套接层）主要用于Web的安全传输协议，在传输层对网络连接进行加密，保障在Internet上数据传输的安全。

- `HTTP`的端口号为`80`，
- `HTTPS`的端口号为`443

## 如果让你写一个消息队列，该如何进行架构设计？说一下你的思路。

比如说这个消息队列系统，我们从以下几个角度来考虑一下：

- 首先这个 mq 得支持可伸缩性吧，就是需要的时候快速扩容，就可以增加吞吐量和容量，那怎么搞？设计个分布式的系统呗，参照一下 kafka 的设计理念，broker -> topic -> partition，每个 partition 放一个机器，就存一部分数据。如果现在资源不够了，简单啊，给 topic 增加 partition，然后做数据迁移，增加机器，不就可以存放更多数据，提供更高的吞吐量了？
- 其次你得考虑一下这个 mq 的数据要不要落地磁盘吧？那肯定要了，落磁盘才能保证别进程挂了数据就丢了。那落磁盘的时候怎么落啊？顺序写，这样就没有磁盘随机读写的寻址开销，磁盘顺序读写的性能是很高的，这就是 kafka 的思路。
- 其次你考虑一下你的 mq 的可用性啊？这个事儿，具体参考之前可用性那个环节讲解的 kafka 的高可用保障机制。多副本 -> leader & follower -> broker 挂了重新选举 leader 即可对外服务。
- 能不能支持数据 0 丢失啊？可以的，参考我们之前说的那个 kafka 数据零丢失方案。 

## 如何保证消息的可靠性传输？或者说，如何处理消息丢失的问题？

生产者弄丢了数据

生产者将数据发送到 RabbitMQ 的时候，可能数据就在半路给搞丢了，因为网络问题啥的，都有可能。

此时可以选择用 RabbitMQ 提供的事务功能，就是生产者**发送数据之前**开启 RabbitMQ 事务`channel.txSelect`，然后发送消息，如果消息没有成功被 RabbitMQ 接收到，那么生产者会收到异常报错，此时就可以回滚事务`channel.txRollback`，然后重试发送消息；如果收到了消息，那么可以提交事务`channel.txCommit`。 

```java
// 开启事务
channel.txSelect
try {
    // 这里发送消息
} catch (Exception e) {
    channel.txRollback

    // 这里再次重发这条消息
}

// 提交事务
channel.txCommit
```

但是问题是，RabbitMQ 事务机制（同步）一搞，基本上**吞吐量会下来，因为太耗性能**。

所以一般来说，如果你要确保说写 RabbitMQ 的消息别丢，可以开启 `confirm` 模式，在生产者那里设置开启 `confirm` 模式之后，你每次写的消息都会分配一个唯一的 id，然后如果写入了 RabbitMQ 中，RabbitMQ 会给你回传一个 `ack` 消息，告诉你说这个消息 ok 了。如果 RabbitMQ 没能处理这个消息，会回调你的一个 `nack` 接口，告诉你这个消息接收失败，你可以重试。而且你可以结合这个机制自己在内存里维护每个消息 id 的状态，如果超过一定时间还没接收到这个消息的回调，那么你可以重发。

事务机制和 `confirm` 机制最大的不同在于，**事务机制是同步的**，你提交一个事务之后会**阻塞**在那儿，但是 `confirm` 机制是**异步**的，你发送个消息之后就可以发送下一个消息，然后那个消息 RabbitMQ 接收了之后会异步回调你的一个接口通知你这个消息接收到了。

所以一般在生产者这块**避免数据丢失**，都是用 `confirm` 机制的。

RabbitMQ 弄丢了数据

就是 RabbitMQ 自己弄丢了数据，这个你必须**开启 RabbitMQ 的持久化**，就是消息写入之后会持久化到磁盘，哪怕是 RabbitMQ 自己挂了，**恢复之后会自动读取之前存储的数据**，一般数据不会丢。除非极其罕见的是，RabbitMQ 还没持久化，自己就挂了，**可能导致少量数据丢失**，但是这个概率较小。

设置持久化有**两个步骤**：

- 创建 queue 的时候将其设置为持久化
  这样就可以保证 RabbitMQ 持久化 queue 的元数据，但是它是不会持久化 queue 里的数据的。
- 第二个是发送消息的时候将消息的 `deliveryMode` 设置为 2
  就是将消息设置为持久化的，此时 RabbitMQ 就会将消息持久化到磁盘上去。

必须要同时设置这两个持久化才行，RabbitMQ 哪怕是挂了，再次重启，也会从磁盘上重启恢复 queue，恢复这个 queue 里的数据。

注意，哪怕是你给 RabbitMQ 开启了持久化机制，也有一种可能，就是这个消息写到了 RabbitMQ 中，但是还没来得及持久化到磁盘上，结果不巧，此时 RabbitMQ 挂了，就会导致内存里的一点点数据丢失。

所以，持久化可以跟生产者那边的 `confirm` 机制配合起来，只有消息被持久化到磁盘之后，才会通知生产者 `ack` 了，所以哪怕是在持久化到磁盘之前，RabbitMQ 挂了，数据丢了，生产者收不到 `ack`，你也是可以自己重发的。

消费端弄丢了数据

RabbitMQ 如果丢失了数据，主要是因为你消费的时候，**刚消费到，还没处理，结果进程挂了**，比如重启了，那么就尴尬了，RabbitMQ 认为你都消费了，这数据就丢了。

这个时候得用 RabbitMQ 提供的 `ack` 机制，简单来说，就是你必须关闭 RabbitMQ 的自动 `ack`，可以通过一个 api 来调用就行，然后每次你自己代码里确保处理完的时候，再在程序里 `ack` 一把。这样的话，如果你还没处理完，不就没有 `ack`了？那 RabbitMQ 就认为你还没处理完，这个时候 RabbitMQ 会把这个消费分配给别的 consumer 去处理，消息是不会丢的。

Kafka

消费端弄丢了数据

唯一可能导致消费者弄丢数据的情况，就是说，你消费到了这个消息，然后消费者那边**自动提交了 offset**，让 Kafka 以为你已经消费好了这个消息，但其实你才刚准备处理这个消息，你还没处理，你自己就挂了，此时这条消息就丢咯。

这不是跟 RabbitMQ 差不多吗，大家都知道 Kafka 会自动提交 offset，那么只要**关闭自动提交** offset，在处理完之后自己手动提交 offset，就可以保证数据不会丢。但是此时确实还是**可能会有重复消费**，比如你刚处理完，还没提交 offset，结果自己挂了，此时肯定会重复消费一次，自己保证幂等性就好了。

生产环境碰到的一个问题，就是说我们的 Kafka 消费者消费到了数据之后是写到一个内存的 queue 里先缓冲一下，结果有的时候，你刚把消息写入内存 queue，然后消费者会自动提交 offset。然后此时我们重启了系统，就会导致内存 queue 里还没来得及处理的数据就丢失了。

Kafka 弄丢了数据

这块比较常见的一个场景，就是 Kafka 某个 broker 宕机，然后重新选举 partition 的 leader。大家想想，要是此时其他的 follower 刚好还有些数据没有同步，结果此时 leader 挂了，然后选举某个 follower 成 leader 之后，不就少了一些数据？这就丢了一些数据啊。

生产环境也遇到过，我们也是，之前 Kafka 的 leader 机器宕机了，将 follower 切换为 leader 之后，就会发现说这个数据就丢了。

所以此时一般是要求起码设置如下 4 个参数：

- 给 topic 设置 `replication.factor` 参数：这个值必须大于 1，要求每个 partition 必须有至少 2 个副本。
- 在 Kafka 服务端设置 `min.insync.replicas` 参数：这个值必须大于 1，这个是要求一个 leader 至少感知到有至少一个 follower 还跟自己保持联系，没掉队，这样才能确保 leader 挂了还有一个 follower 吧。
- 在 producer 端设置 `acks=all`：这个是要求每条数据，必须是**写入所有 replica 之后，才能认为是写成功了**。
- 在 producer 端设置 `retries=MAX`（很大很大很大的一个值，无限次重试的意思）：这个是**要求一旦写入失败，就无限重试**，卡在这里了。

我们生产环境就是按照上述要求配置的，这样配置之后，至少在 Kafka broker 端就可以保证在 leader 所在 broker 发生故障，进行 leader 切换时，数据不会丢失。

生产者会不会弄丢数据？

如果按照上述的思路设置了 `acks=all`，一定不会丢，要求是，你的 leader 接收到消息，所有的 follower 都同步到了消息之后，才认为本次写成功了。如果没满足这个条件，生产者会自动不断的重试，重试无限次。

## 如何保证消息不被重复消费？或者说，如何保证消息消费的幂等性？ 

一条数据重复出现两次，数据库里就只有一条数据，这就保证了系统的幂等性。

幂等性，通俗点说，就一个数据，或者一个请求，给你重复来多次，你得确保对应的数据是不会改变的，**不能出错**。

所以第二个问题来了，怎么保证消息队列消费的幂等性？

其实还是得结合业务来思考，我这里给几个思路：

- 比如你拿个数据要写库，你先根据主键查一下，如果这数据都有了，你就别插入了，update 一下好吧。
- 比如你是写 Redis，那没问题了，反正每次都是 set，天然幂等性。
- 比如你不是上面两个场景，那做的稍微复杂一点，你需要让生产者发送每条数据的时候，里面加一个全局唯一的 id，类似订单 id 之类的东西，然后你这里消费到了之后，先根据这个 id 去比如 Redis 里查一下，之前消费过吗？如果没有消费过，你就处理，然后这个 id 写 Redis。如果消费过了，那你就别处理了，保证别重复处理相同的消息即可。
- 比如基于数据库的唯一键来保证重复数据不会重复插入多条。因为有唯一键约束了，重复数据插入只会报错，不会导致数据库中出现脏数据。

## 一、常见的模式与工具（学习计划）

阅读源码： spring 概述  spring Framework体系结构、环境

Spring容器：容器基本实现和组成、配置Bean的方式、BeanFactory的源码分析、BeanDefintion源码分析、Bean生命周期、依赖.

springAOP:面向切面的基础、AOP源码分析、事务分析、Spring Cache框架源码。

Spring5新特性：容器增强、函数式编程、Webflux模块介绍、Kotlin介绍、测试改进、兼容性

Mybatis: 组成、核心源码分析、手写的Mybatis.

## 二、工程化和工具

Maven的项目集成、Jenkins持续集成、Sonar代码质量管理、Git的版本管理。

三、分布式架构

分布式架构原理、分布式架构策略、分布式中间件、分布式架构实战、RPC、分布式系统指挥官ZooKeeper、Dubbo框架

RPC:模式介绍、常见的RPC技术介绍、网络协议分析、开发一个RPC实现

CAP理论、ZooKeeper介绍、ZooKeeper基础、ZooKeeper高级进阶

Dubbo框架、使用介绍、服务化思维、特性、源码导读、常见问题

四、微服务架构

微服务框架、Spring Cloud、Docker与虚拟化、微服务架构

五、性能优化

性能指标体系、JVM调优、网络调优、DB调优、集群：多机器做同一件事情、JVM优化、WEB程序优化、SQL优化

JVM调优：javaXXX--->装载配置--->根据当前路径和系统版本寻找jvm.cfg

​						    --->根据配置寻找JVM.dll--->JVM.dll为JVM主要实现

​										           --->初始化JVM获得JNIEnv接口			