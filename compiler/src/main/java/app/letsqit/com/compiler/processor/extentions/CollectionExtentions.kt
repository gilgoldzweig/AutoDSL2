package app.letsqit.com.compiler.processor.extentions

/**
 * Created by gilgoldzweig on 08/07/2017.
 */
fun <E> Collection<E>?.isNullOrEmpty() = this == null || this.isEmpty()
