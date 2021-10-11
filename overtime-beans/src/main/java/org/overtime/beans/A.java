package org.overtime.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.Contract;

/**
 * 临时占位文件。
 *
 * @author ForteScarlet
 */
@Data
@AllArgsConstructor
public class A {
    private String name;

    @Contract(pure = true)
    public A copy() {
        return new A(name);
    }

    @Contract(mutates = "this,param2")
    public void changeName(A a, A b, String name) {
        this.name = name;
        a.name = name;
    }

}
