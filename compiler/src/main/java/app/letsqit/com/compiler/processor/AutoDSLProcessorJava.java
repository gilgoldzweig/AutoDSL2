package app.letsqit.com.compiler.processor;

import app.letsqit.com.annotations.annotations.AutoDSL;
import app.letsqit.com.annotations.annotations.AutoDSLJava;
import app.letsqit.com.annotations.annotations.Column;
import app.letsqit.com.annotations.annotations.ColumnJava;
import app.letsqit.com.compiler.processor.extentions.CollectionExtentionsKt;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public class AutoDSLProcessorJava extends AbstractProcessor {
   private Types typeUtils;
   private Elements elementUtils;
   private Filer filer;
   private Messager messager;
   private Map options;
   private boolean firstProcess = true;

   public boolean process(@NotNull Set annotations, @NotNull RoundEnvironment roundEnv) {
      Intrinsics.checkParameterIsNotNull(annotations, "annotations");
      Intrinsics.checkParameterIsNotNull(roundEnv, "roundEnv");
      if(this.firstProcess) {
         EnvironmentUtil var10000 = EnvironmentUtil.INSTANCE;
         ProcessingEnvironment var10001 = this.processingEnv;
         Intrinsics.checkExpressionValueIsNotNull(this.processingEnv, "processingEnv");
         var10000.init(var10001);
         this.firstProcess = false;
      }

      try {
         return this.processClass(roundEnv) && this.processColumns(roundEnv);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return true;
   }

//   private final void proccessType() {
//      Map var10000 = this.options;
//      if(this.options == null) {
//         Intrinsics.throwUninitializedPropertyAccessException("options");
//      }
//
//      String generatedPath = (String)var10000.get("kapt.kotlin.generated");
//      String var9;
//      if(generatedPath != null) {
//         CharSequence var3 = generatedPath;
//         String var4 = "(.*)tmp(/kapt/debug/)kotlinGenerated";
//         Regex var7 = new Regex(var4);
//         String var5 = "$1generated/source$2";
//         var9 = var7.replace(var3, var5);
//      } else {
//         var9 = null;
//      }
//
//      String path = var9;
//      ClassName greeterClass = ClassName.Companion.get("com.lets", "Gil");
//      KotlinFile kotlinFile = KotlinFile.Companion.builder("", "HelloWorld").addType(TypeSpec.Companion.classBuilder("Greeter").addModifiers().primaryConstructor(FunSpec.Companion.constructorBuilder().addParameter("name", Reflection.getOrCreateKotlinClass(String.class), new KModifier[0]).build()).addProperty(PropertySpec.Companion.builder("name", Reflection.getOrCreateKotlinClass(String.class), new KModifier[0]).initializer("name", new Object[0]).build()).addFun(FunSpec.Companion.builder("greet").addStatement("println(%S)", new Object[]{"Hello, $name"}).build()).build()).addFun(FunSpec.Companion.builder("main").addParameter("args", Reflection.getOrCreateKotlinClass(String.class), new KModifier[]{KModifier.VARARG}).addStatement("%T(args[0]).greet()", new Object[]{greeterClass}).build()).build();
//      Path var10001 = (new File(path)).toPath();
//      Intrinsics.checkExpressionValueIsNotNull(var10001, "File(path).toPath()");
//      kotlinFile.writeTo(var10001);
//      PrintStream var10 = System.out;
//      Intrinsics.checkExpressionValueIsNotNull(System.out, "System.out");
//      kotlinFile.writeTo(var10);
//   }

   public final boolean processClass(@NotNull RoundEnvironment roundEnv) throws Exception {
      Intrinsics.checkParameterIsNotNull(roundEnv, "roundEnv");
      Set elements = roundEnv.getElementsAnnotatedWith(AutoDSL.class);
      if(CollectionExtentionsKt.isNullOrEmpty(elements)) {
         return true;
      } else {
         Iterator var4 = elements.iterator();

         Element element;
         do {
            if(!var4.hasNext()) {
               return true;
            }

            element = (Element)var4.next();
            if(Intrinsics.areEqual(element.getKind(), ElementKind.CLASS) ^ true) {
               EnvironmentUtil.INSTANCE.logError("AutoDSL can only be used for classes!");
               return false;
            }

            if(element == null) {
               throw new TypeCastException("null cannot be cast to non-null type javax.lang.model.element.TypeElement");
            }
         } while(this.generateDSLClasses((TypeElement)element));

         return false;
      }
   }

   private final boolean generateDSLClasses(TypeElement element) throws Exception {
      EnvironmentUtil.INSTANCE.logWarning("ClassName: DSL" + element.getSimpleName());
      Iterator var3 = element.getEnclosedElements().iterator();

      while(var3.hasNext()) {
         Element subElement = (Element)var3.next();
         EnvironmentUtil.INSTANCE.logWarning("ClassFields:" + subElement.getSimpleName());
      }

      return true;
   }

   private final boolean processColumns(RoundEnvironment roundEnv) throws Exception {
      Set elements = roundEnv.getElementsAnnotatedWith(Column.class);
      if(CollectionExtentionsKt.isNullOrEmpty(elements)) {
         return true;
      } else {
         Iterator var4 = elements.iterator();

         Element element;
         do {
            if(!var4.hasNext()) {
               return true;
            }

            element = (Element)var4.next();
            if(Intrinsics.areEqual(element.getKind(), ElementKind.CLASS) ^ true) {
               EnvironmentUtil.INSTANCE.logError("Column can only be used for classes!");
               return false;
            }

            if(element == null) {
               throw new TypeCastException("null cannot be cast to non-null type javax.lang.model.element.TypeElement");
            }
         } while(this.generateDSLClasses((TypeElement)element));

         return false;
      }
   }

   @NotNull
   public Set getSupportedAnnotationTypes() {
      return SetsKt.setOf(AutoDSL.class.getCanonicalName(), Column.class.getCanonicalName(), AutoDSLJava.class.getCanonicalName(), ColumnJava.class.getCanonicalName());
   }

   @NotNull
   public SourceVersion getSupportedSourceVersion() {
      return SourceVersion.RELEASE_7;
   }
}
