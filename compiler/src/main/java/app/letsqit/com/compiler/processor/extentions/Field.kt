package app.letsqit.com.compiler.processor.extentions

import com.squareup.kotlinpoet.ClassName

/**
 * Created by gilgoldzweig on 12/08/2017.
 */
data class Field(val fieldName: String,
                 val fieldClass: ClassName,
                 val genericTypes: Iterable<String> = emptyList(),
                 val nullable: Boolean = false)