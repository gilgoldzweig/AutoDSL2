package app.letsqit.com.annotations.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import kotlin.annotation.AnnotationTarget;

/**
 * Created by gilgoldzweig on 07/07/2017.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
public @interface ColumnJava {
    String columnName() default "";
    boolean ignore() default false;
}
