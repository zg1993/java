package net.zhou;
import net.Pac;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;



public class Vector {
    public static void main(String[] args) {
	Pac p = new Pac();
	p.get();
    }

    public void get() {
        System.out.println("I'm vector");
    }

}
