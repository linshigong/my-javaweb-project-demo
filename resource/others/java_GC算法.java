 Java GC 算法

当一个对象不再被引用的时候，内存回收它占领的空间，以便空间被后来的新对象使用。除了释放没用的对象，垃圾收集也可以清除内存记录碎片。

1、 引用计数法(Reference Counting Collector)

    引用计数法是唯一没有使用根集的垃圾回收的法，该算法使用引用计数器来区分存活对象和不再使用的对象。一般来说，堆中的每个对象对应一个引用计数器。当每一次创建一个对象并赋给一个变量时，引用计数器置为1。当对象被赋给任意变量时，引用计数器每次加1当对象出了作用域后(该对象丢弃不再使用)，引用计数器减1，一旦引用计数器为0，对象就满足了垃圾收集的条件。
    基于引用计数器的垃圾收集器运行较快，不会长时间中断程序执行，适宜地必须 实时运行的程序。但引用计数器增加了程序执行的开销，因为每次对象赋给新的变量，计数器加1，而每次现有对象出了作用域生，计数器减1。
　　
ps：用根集的方法（既有向图的方法）进行内存对象管理，可以消除循环引用的问题．就是说如果有三个对象相互引用，只要他们和根集是不可达的，gc也是可以回收他们．根集的方法精度很高，但是效率低．计数器法精度低（无法处理循环引用），但是执行效率高．

2、tracing算法(Tracing Collector)

    tracing算法是为了解决引用计数法的问题而提出，它使用了根集的概念。基于tracing算法的垃圾收集器从根集开始扫描，识别出哪些对象可达，哪些对象不可达，并用某种方式标记可达对象，例如对每个可达对象设置一个或多个位。在扫描识别过程中，基于tracing算法的垃圾收集也称为标记和清除 (mark-and-sweep)垃圾收集器。

3、compacting算法(Compacting Collector)

    为了解决堆碎片问题，基于tracing的垃圾回收吸收了Compacting算法的思想，在清除的过程中，算法将所有的对象移到堆的一端，堆的另一端就变成了一个相邻的空闲内存区，收集器会对它移动的所有对象的所有引用进行更新，使得这些引用在新的位置能识别原来 的对象。在基于Compacting 算法的收集器的实现中，一般增加句柄和句柄表。

4、copying算法(Coping Collector)

    该算法的提出是为了克服句柄的开销和解决堆碎片的垃圾回收。
    将内存分为两个区域(from space和to space)。所有的对象分配内存都分配到from space。在清理非活动对象阶段，把所有标志为活动的对象，copy到to space，之后清楚from space空间。然后互换from sapce和to space的身份。既原先的from space变成to sapce，原先的to space变成from space。每次清理，重复上述过程。
    优点：copy算法不理会非活动对象，copy数量仅仅取决为活动对象的数量。并且在copy的同时，整理了heap空间，即，to space的空间使用始终是连续的，内存使用效率得到提高。
    缺点：划分from space和to space，内存的使用率是1／2。收集器必须复制所有的活动对象，这增加了程序等待时间。

5、generation算法(Generational Collector)

    来自IBM的一组统计数据：98％的java对象，在创建之后不久就变成了非活动对象；只有2％的对象，会在长时间一直处于活动状态。

     (1)young generation

    年轻代分三个区。一个Eden区，两个Survivor区。大部分对象在 Eden区中生成。当Eden区满时，还存活的对象将被复制到Survivor区（两个中的一个），当这个Survivor区满时，此区的存活对象将被复制到另外一个Survivor区，当这个Survivor区也满了的时候，从第一个Survivor区复制过来的并且此时还存活的对象，将被复制到 tenured generation。需要注意，Survivor的两个区是对称的，没先后关系，所以同一个区中可能同时存在从Eden复制过来对象，和从前一个 Survivor复制过来的对象，而复制到年老区的只有从第一个Survivor去过来的对象。而且，Survivor区总有一个是空的。
    young generation的gc称为minor gc。经过数次minor gc，依旧存活的对象，将被移出young generation，移到tenured generation

    (2)tenured generation

    生命周期较长的对象，归入到tenured generation。一般是经过多次minor gc，还 依旧存活的对象，将移入到tenured generation。（当然，在minor gc中如果存活的对象的超过survivor的容量，放不下的对象会直接移入到tenured generation）
tenured generation的gc称为major gc，就是通常说的full gc。
    采用compaction算法。由于tenured generaion区域比较大，而且通常对象生命周期都比较长，compaction需要一定时间。所以这部分的gc时间比较长。
    minor gc可能引发full gc。当eden＋from space的空间大于tenured generation区的剩余空间时，会引发full gc。这是悲观算法，要确保eden＋from space的对象如果都存活，必须有足够的tenured generation空间存放这些对象。

    (3)permanent generation

    该区域比较稳定，主要用于存放classloader信息，比如类信息和method信息。
对于spring hibernate这些需要动态类型支持的框架，这个区域需要足够的空间。(这部分空间应该存在于方法区而不是heap中)。

6、adaptive算法(Adaptive Collector)

    在特定的情况下，一些垃圾收集算法会优于其它算法。基于Adaptive算法的垃圾收集器就是监控当前堆的使用情况，并将选择适当算法的垃圾收集器。

from: http://blog.csdn.net/salahg/article/details/5912101Molator's Downloads