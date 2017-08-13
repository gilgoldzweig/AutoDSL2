package app.letsqit.com.compiler.processor.class_generator

import app.letsqit.com.compiler.processor.extentions.Field
import com.squareup.kotlinpoet.ClassName

/**
 * Created by gilgoldzweig on 28/07/2017.
 */
data class ConfigurationFile(var generatedClassName: String = "",
                             var extendingClass: Field,
                             var finalElementsForDeclaration: Iterable<FunctionConfigurationFile> = emptyList(),
                             var functions: Iterable<FunctionConfigurationFile> = emptyList())