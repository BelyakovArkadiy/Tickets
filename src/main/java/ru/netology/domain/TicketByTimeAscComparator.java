package ru.netology.domain;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class TicketByTimeAscComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime()-o2.getTime();
    }

    @Override
    public Comparator<Ticket> reversed() {
        return null;
    }

    @Override
    public Comparator<Ticket> thenComparing(Comparator<? super Ticket> other) {
        return null;
    }

    @Override
    public <U> Comparator<Ticket> thenComparing(Function<? super Ticket, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return null;
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Ticket> thenComparing(Function<? super Ticket, ? extends U> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Ticket> thenComparingInt(ToIntFunction<? super Ticket> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Ticket> thenComparingLong(ToLongFunction<? super Ticket> keyExtractor) {
        return null;
    }

    @Override
    public Comparator<Ticket> thenComparingDouble(ToDoubleFunction<? super Ticket> keyExtractor) {
        return null;
    }
}
