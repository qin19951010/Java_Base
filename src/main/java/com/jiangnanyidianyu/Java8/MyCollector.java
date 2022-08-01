package com.jiangnanyidianyu.Java8;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author QinZhongliang
 * @date 2022年07月29日 2:27 PM
 */
public class MyCollector implements Collector {
    @Override
    //创建新的结果容器，可以是一个容器，也可以是一个累加器实例，总之是用来存储结果数据的
    public Supplier supplier() {

        return null;
    }

    @Override
    //元素进入收集器中的具体处理操作
    public BiConsumer accumulator() {
        return null;
    }

    @Override
    //各个子流的处理结果最终如何合并到一起去，比如并行流处理场景，元素会被切分为好多个分片进行并行处理，
    //最终各个分片的数据需要合并为一个整体结果，即通过此方法来指定子结果的合并逻辑
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    //当所有元素都处理完成后，在返回结果前的对结果的最终处理操作，当然也可以选择不做任何处理，直接返回
    public Function finisher() {
        return null;
    }

    @Override
    //对此收集器处理行为的补充描述，比如此收集器是否允许并行流中处理，是否finisher方法必须要有等等，
    //此处返回一个Set集合，里面的候选值是固定的几个可选项。
    public Set<Characteristics> characteristics() {
        return null;
    }
}
