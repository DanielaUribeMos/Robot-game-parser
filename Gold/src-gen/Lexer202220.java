// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/Lexer202220.gold"
import gold.*;
import gold.structures.*;
import gold.structures.automaton.*;
import gold.structures.bag.*;
import gold.structures.collection.*;
import gold.structures.deque.*;
import gold.structures.disjointset.*;
import gold.structures.graph.*;
import gold.structures.heap.*;
import gold.structures.list.*;
import gold.structures.map.*;
import gold.structures.multimap.*;
import gold.structures.point.*;
import gold.structures.queue.*;
import gold.structures.set.*;
import gold.structures.stack.*;
import gold.structures.tree.*;
import gold.structures.tree.binary.*;
import gold.structures.tree.nary.*;
import gold.structures.tuple.*;
import gold.structures.turingMachine.*;
import gold.swing.*;
import gold.swing.icon.*;
import gold.swing.icon.ajaxload.*;
import gold.swing.icon.famfamfam.*;
import gold.swing.icon.gold.*;
import gold.swing.icon.jlfgr.*;
import gold.swing.icon.wikimedia.*;
import gold.swing.icon.windows.*;
import gold.swing.look.*;
import gold.swing.util.*;
import gold.test.*;
import gold.test.automaton.*;
import gold.test.general.*;
import gold.test.graph.*;
import gold.util.*;
import gold.visualization.*;
import gold.visualization.automaton.*;
import gold.visualization.graph.*;
import gold.visualization.quadtree.*;
import gold.visualization.turingMachine.*;
import gold.visualization.util.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class Lexer202220 {
  public static String currentString=null;
  static {
    int $line=0;
    $line=3;
    $try:try {
      currentString=$defaultValue(String.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static GArrayList images=null;
  static {
    int $line=0;
    $line=4;
    $try:try {
      images=$invokeConstructor(GArrayList.class,new Object[]{});
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet allSymbols=null;
  static {
    int $line=0;
    $line=6;
    $try:try {
      allSymbols=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet keyWords=null;
  static {
    int $line=0;
    $line=7;
    $try:try {
      keyWords=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet skipChars=null;
  static {
    int $line=0;
    $line=8;
    $try:try {
      skipChars=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet preKW=null;
  static {
    int $line=0;
    $line=10;
    $try:try {
      preKW=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet preOps=null;
  static {
    int $line=0;
    $line=11;
    $try:try {
      preOps=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet StartOps=null;
  static {
    int $line=0;
    $line=13;
    $try:try {
      StartOps=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet Symbols1=null;
  static {
    int $line=0;
    $line=14;
    $try:try {
      Symbols1=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet CharsSymbols1=null;
  static {
    int $line=0;
    $line=16;
    $try:try {
      CharsSymbols1=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet alphaUpper=null;
  static {
    int $line=0;
    $line=18;
    $try:try {
      alphaUpper=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet alphaLower=null;
  static {
    int $line=0;
    $line=19;
    $try:try {
      alphaLower=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet digits=null;
  static {
    int $line=0;
    $line=20;
    $try:try {
      digits=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet alphaNum=null;
  static {
    int $line=0;
    $line=22;
    $try:try {
      alphaNum=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet Out=null;
  static {
    int $line=0;
    $line=24;
    $try:try {
      Out=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static Boolean diffIdents=null;
  static {
    int $line=0;
    $line=25;
    $try:try {
      diffIdents=$defaultValue(Boolean.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static ISet Ids=null;
  static {
    int $line=0;
    $line=27;
    $try:try {
      Ids=$defaultValue(ISet.class);
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static GHashTableMap translation=null;
  static {
    int $line=0;
    $line=28;
    $try:try {
      translation=$invokeConstructor(GHashTableMap.class,new Object[]{});
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,null,$line);
    }
  }
  public static Object chars(Object string) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v1=$newSet();
      int $v3=$int(0);
      int $v4=$int($invokeMethod("length",string,new Object[]{}))-1;
      $v2:for (int i=$v3; i<=$v4; i++) {
        $v1.add($invokeMethod("charAt",string,new Object[]{i}));
      }
      $result=$v1;
      if (true) break $try;
      $line=31;
      $rethrow(new RuntimeException("The function \"chars(string:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"chars",$line);
    }
    return $result;
  }
  public static Object charsStrings(Object strings) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v5=$newSet(GCollections.emptySet());
      $v6:for (Object s:GCollections.unmodifiableCollection(strings)) {
        $v5.union(GCollections.unmodifiableSet(((java.lang.Iterable)(Lexer202220.chars(s)))));
      }
      $result=$v5;
      if (true) break $try;
      $line=33;
      $rethrow(new RuntimeException("The function \"charsStrings(strings:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"charsStrings",$line);
    }
    return $result;
  }
  public static Object elements(Object array) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v7=$newSet();
      int $v9=$int(0);
      int $v10=$int($opAbsolY(array))-1;
      $v8:for (int i=$v9; i<=$v10; i++) {
        $v7.add($getArrayValue(array,new Object[]{i}));
      }
      $result=$v7;
      if (true) break $try;
      $line=35;
      $rethrow(new RuntimeException("The function \"elements(array:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"elements",$line);
    }
    return $result;
  }
  public static Object prefixes(Object string) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v11=$newSet();
      int $v13=$int(1);
      int $v14=$int($invokeMethod("length",string,new Object[]{}));
      $v12:for (int i=$v13; i<=$v14; i++) {
        $v11.add($invokeMethod("substring",string,new Object[]{0,i}));
      }
      $result=$v11;
      if (true) break $try;
      $line=37;
      $rethrow(new RuntimeException("The function \"prefixes(string:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"prefixes",$line);
    }
    return $result;
  }
  public static Object splits(Object string) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v15=$newSet();
      int $v17=$int(1);
      int $v18=$int($opSubtrY($invokeMethod("length",string,new Object[]{}),1));
      $v16:for (int i=$v17; i<=$v18; i++) {
        $v15.add(GCollections.asList($invokeMethod("substring",string,new Object[]{0,i}),$invokeMethod("substring",string,new Object[]{i,$invokeMethod("length",string,new Object[]{})})));
      }
      $result=$v15;
      if (true) break $try;
      $line=38;
      $rethrow(new RuntimeException("The function \"splits(string:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"splits",$line);
    }
    return $result;
  }
  public static Object allPrefixes(Object strings) {
    int $line=0;
    Object $result=null;
    $try:try {
      gold.structures.set.ISet $v19=$newSet(GCollections.emptySet());
      $v20:for (Object s:GCollections.unmodifiableCollection(strings)) {
        $v19.union(GCollections.unmodifiableSet(((java.lang.Iterable)(Lexer202220.prefixes(s)))));
      }
      $result=$v19;
      if (true) break $try;
      $line=40;
      $rethrow(new RuntimeException("The function \"allPrefixes(strings:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"allPrefixes",$line);
    }
    return $result;
  }
  public static Object translationGet(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=(($bool((($opEqualY($opAbsolY(q),1)&&$opMembrY(q,Symbols1))&&!$opEqualY(q,'\n'))))?(q):(((gold.structures.map.GHashTableMap)translation).get(q)));
      if (true) break $try;
      $line=42;
      $rethrow(new RuntimeException("The function \"translationGet(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"translationGet",$line);
    }
    return $result;
  }
  public static Object runLexer(Object M, Object input) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=45;
      currentString=$cast(String.class,$fix(""));
      $line=46;
      images=$cast(GArrayList.class,$fix($invokeConstructor(GArrayList.class,new Object[]{})));
      $line=47;
      Object result=$fix($invokeMethod("acceptsString",M,new Object[]{input}));
      $line=48;
      $result=GCollections.asList(result,images);
      if (true) break $try;
      $line=49;
      $rethrow(new RuntimeException("The function \"runLexer(M:Object,input:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"runLexer",$line);
    }
    return $result;
  }
  public static Object problems(String q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=53;
      if ($opMembrY(q,allSymbols)) {
        $line=53;
        $result=false;
        if (true) break $try;
      }
      else {
        $line=54;
        if ($opLessqY($opAbsolY(q),1)) {
          $line=54;
          $result=true;
          if (true) break $try;
        }
        else {
          $line=56;
          for (Object $v21:GCollections.unmodifiableCollection(Lexer202220.splits(q))) {
            java.util.Iterator $v22=GCollections.unmodifiableCollection($v21).iterator();
            Object s=$v22.next();
            Object t=$v22.next();
            $line=57;
            if ((!$bool(Lexer202220.problems($cast(java.lang.String.class,s)))&&!$bool(Lexer202220.problems($cast(java.lang.String.class,t))))) {
              $line=57;
              $result=false;
              if (true) break $try;
            }
          }
          $line=59;
          $result=true;
          if (true) break $try;
        }
      }
      $line=62;
      $rethrow(new RuntimeException("The function \"problems(q:String)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"problems",$line);
    }
    return $result;
  }
  public static Object translationPreOps(Object state) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=66;
      Object x=null;
      Object y=null;
      $line=67;
      String q=null;
      q=$defaultValue(String.class);
      $line=68;
      q=$cast(String.class,$fix(state));
      $line=69;
      Object n=$fix(((java.lang.String)q).length());
      $line=70;
      if ($opEqualY(n,0)) {
        $line=70;
        $result="";
        if (true) break $try;
      }
      else {
        $line=71;
        if ($opMembrY(q,allSymbols)) {
          $line=72;
          ((gold.structures.list.GArrayList)images).add(q);
          $line=73;
          $result=Lexer202220.translationGet(q);
          if (true) break $try;
        }
        else {
          $line=74;
          if ($opEqualY(n,1)) {
            $line=74;
            $result="";
            if (true) break $try;
          }
          else {
            $line=76;
            for (Object $v23:GCollections.unmodifiableCollection(Lexer202220.splits(q))) {
              java.util.Iterator $v24=GCollections.unmodifiableCollection($v23).iterator();
              Object s=$v24.next();
              Object t=$v24.next();
              $line=77;
              x=$fix(Lexer202220.translationPreOps(s));
              $line=78;
              y=$fix(Lexer202220.translationPreOps(t));
              $line=79;
              if ((!$opEqualY(x,"")&&!$opEqualY(y,""))) {
                $line=80;
                $result=$opAdditY(x,y);
                if (true) break $try;
              }
            }
            $line=83;
            $result="";
            if (true) break $try;
          }
        }
      }
      $line=87;
      $rethrow(new RuntimeException("The function \"translationPreOps(state:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"translationPreOps",$line);
    }
    return $result;
  }
  public static ITransducer createLexer() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=91;
      Lexer202220.initialize();
      $line=93;
      preOps=$cast(ISet.class,$fix(Lexer202220.allPrefixes(allSymbols)));
      $line=94;
      preKW=$cast(ISet.class,$fix(Lexer202220.allPrefixes(keyWords)));
      $line=95;
      gold.structures.set.ISet $v25=$newSet(GCollections.emptySet());
      $v26:for (Object x:GCollections.unmodifiableCollection(allSymbols)) {
        $v25.union(GCollections.unmodifiableSet(((java.lang.Iterable)(GCollections.asSet($invokeMethod("charAt",x,new Object[]{0}))))));
      }
      StartOps=$cast(ISet.class,$fix($v25));
      $line=96;
      gold.structures.set.ISet $v27=$newSet(GCollections.emptySet());
      $v28:for (Object x:GCollections.unmodifiableCollection(StartOps)) {
        $v27.union(GCollections.unmodifiableSet(((java.lang.Iterable)(GCollections.asSet($opAdditY("",x))))));
      }
      Symbols1=$cast(ISet.class,$fix($opInterY($v27,allSymbols)));
      $line=97;
      gold.structures.set.ISet $v29=$newSet(GCollections.emptySet());
      $v30:for (Object x:GCollections.unmodifiableCollection(Symbols1)) {
        $v29.union(GCollections.unmodifiableSet(((java.lang.Iterable)(GCollections.asSet($invokeMethod("charAt",x,new Object[]{0}))))));
      }
      CharsSymbols1=$cast(ISet.class,$fix($v29));
      $line=98;
      gold.structures.set.ISet $v31=$newSet(GCollections.emptySet());
      $v32:for (Object x:GCollections.unmodifiableCollection(((gold.structures.map.GHashTableMap)translation).values())) {
        $v31.union(GCollections.unmodifiableSet(((java.lang.Iterable)(GCollections.asSet(x)))));
      }
      Out=$cast(ISet.class,$fix($opUnionY(CharsSymbols1,$v31)));
      $line=100;
      System.out.println($message(new Object[]{Out}));
      $line=101;
      Ids=$cast(ISet.class,$fix(GCollections.asSet("IdU","IdL")));
      $line=103;
      Object Q=$fix($opUnionY($opUnionY(GCollections.asSet("INIT","IdU","Num","Err","IdL"),preKW),preOps));
      $line=105;
      System.out.println($message(new Object[]{Q}));
      $line=107;
      Object \u03A3=$fix($opUnionY($opUnionY($opUnionY(alphaNum,Lexer202220.charsStrings(allSymbols)),skipChars),GCollections.asSet(':','-')));
      $line=110;
      Object q_0=$fix("INIT");
      $line=111;
      Object F=$fix(GCollections.asSet("INIT"));
      $line=112;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,Out,q_0,F,new GMethod(Lexer202220.class,"\u03B4"),new GMethod(Lexer202220.class,"g"),new GMethod(Lexer202220.class,"h")});
      if (true) break $try;
      $line=113;
      $rethrow(new RuntimeException("The function \"createLexer()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"createLexer",$line);
    }
    return $cast(ITransducer.class,$result);
  }
  public static Object \u03B4(Object state, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=118;
      String q=null;
      q=$defaultValue(String.class);
      $line=119;
      q=$cast(String.class,$fix(state));
      $line=121;
      if ($opEqualY(q,"Err")) {
        $line=121;
        $result="Err";
        if (true) break $try;
      }
      else {
        $line=122;
        if ($opMembrY(q,preOps)) {
          $line=123;
          if ($opMembrY($opAdditY(q,\u03C3),preOps)) {
            $line=123;
            $result=$opAdditY(q,\u03C3);
            if (true) break $try;
          }
          else {
            $line=124;
            if ($bool(Lexer202220.problems($cast(java.lang.String.class,q)))) {
              $line=124;
              $result="Err";
              if (true) break $try;
            }
            else {
              $line=125;
              if ($opMembrY(\u03C3,skipChars)) {
                $line=125;
                $result="INIT";
                if (true) break $try;
              }
              else {
                $line=126;
                if ($opMembrY(\u03C3,$opIntvlY('0','9'))) {
                  $line=126;
                  $result="Num";
                  if (true) break $try;
                }
                else {
                  $line=127;
                  if ($opMembrY($opAdditY("",\u03C3),preKW)) {
                    $line=127;
                    $result=$opAdditY("",\u03C3);
                    if (true) break $try;
                  }
                  else {
                    $line=128;
                    if ($opMembrY(\u03C3,alphaUpper)) {
                      $line=128;
                      $result="IdU";
                      if (true) break $try;
                    }
                    else {
                      $line=129;
                      if ($opMembrY(\u03C3,alphaLower)) {
                        $line=129;
                        $result="IdL";
                        if (true) break $try;
                      }
                      else {
                        $line=130;
                        if ($opMembrY($opAdditY("",\u03C3),preOps)) {
                          $line=130;
                          $result=$opAdditY("",\u03C3);
                          if (true) break $try;
                        }
                        else {
                          $line=131;
                          $result="Err";
                          if (true) break $try;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else {
          $line=133;
          if (((($opMembrY(\u03C3,skipChars)&&$opMembrY(q,preKW))&&!$bool($opMembrY(q,keyWords)))&&$opEqualY(((java.lang.String)q).charAt($int(0)),':'))) {
            $line=133;
            $result="Err";
            if (true) break $try;
          }
          else {
            $line=134;
            if ($opMembrY(\u03C3,skipChars)) {
              $line=134;
              $result="INIT";
              if (true) break $try;
            }
            else {
              $line=135;
              if (($opEqualY(q,"INIT")&&$opMembrY(\u03C3,$opIntvlY('0','9')))) {
                $line=135;
                $result="Num";
                if (true) break $try;
              }
              else {
                $line=136;
                if (($opEqualY(q,"INIT")&&$opMembrY($opAdditY("",\u03C3),preKW))) {
                  $line=136;
                  $result=$opAdditY("",\u03C3);
                  if (true) break $try;
                }
                else {
                  $line=137;
                  if (($opEqualY(q,"INIT")&&$opMembrY(\u03C3,alphaUpper))) {
                    $line=137;
                    $result="IdU";
                    if (true) break $try;
                  }
                  else {
                    $line=138;
                    if (($opEqualY(q,"INIT")&&$opMembrY(\u03C3,alphaLower))) {
                      $line=138;
                      $result="IdL";
                      if (true) break $try;
                    }
                    else {
                      $line=139;
                      if (($opEqualY(q,"INIT")&&$opMembrY($opAdditY("",\u03C3),preOps))) {
                        $line=139;
                        $result=$opAdditY("",\u03C3);
                        if (true) break $try;
                      }
                      else {
                        $line=140;
                        if (($opMembrY(q,preKW)&&$opMembrY($opAdditY(q,\u03C3),preKW))) {
                          $line=140;
                          $result=$opAdditY(q,\u03C3);
                          if (true) break $try;
                        }
                        else {
                          $line=141;
                          if ((($opMembrY(q,preKW)&&$opMembrY(\u03C3,alphaNum))&&$opMembrY(((java.lang.String)q).charAt($int(0)),alphaUpper))) {
                            $line=141;
                            $result="IdU";
                            if (true) break $try;
                          }
                          else {
                            $line=142;
                            if ((($opMembrY(q,preKW)&&$opMembrY(\u03C3,alphaNum))&&$opMembrY(((java.lang.String)q).charAt($int(0)),alphaLower))) {
                              $line=142;
                              $result="IdL";
                              if (true) break $try;
                            }
                            else {
                              $line=143;
                              if (($opMembrY(q,preKW)&&$opMembrY($opAdditY("",\u03C3),preOps))) {
                                $line=143;
                                $result=$opAdditY("",\u03C3);
                                if (true) break $try;
                              }
                              else {
                                $line=144;
                                if (($opEqualY(q,"Num")&&$opMembrY(\u03C3,$opIntvlY('0','9')))) {
                                  $line=144;
                                  $result="Num";
                                  if (true) break $try;
                                }
                                else {
                                  $line=145;
                                  if (($opEqualY(q,"Num")&&$opMembrY($opAdditY("",\u03C3),preOps))) {
                                    $line=145;
                                    $result=$opAdditY("",\u03C3);
                                    if (true) break $try;
                                  }
                                  else {
                                    $line=146;
                                    if (($opEqualY(q,"Num")&&$opMembrY(\u03C3,alphaNum))) {
                                      $line=146;
                                      $result="Err";
                                      if (true) break $try;
                                    }
                                    else {
                                      $line=147;
                                      if (($opMembrY(q,Ids)&&$opMembrY(\u03C3,alphaNum))) {
                                        $line=147;
                                        $result=q;
                                        if (true) break $try;
                                      }
                                      else {
                                        $line=148;
                                        if (($opMembrY(q,Ids)&&$opMembrY($opAdditY("",\u03C3),preOps))) {
                                          $line=148;
                                          $result=$opAdditY("",\u03C3);
                                          if (true) break $try;
                                        }
                                        else {
                                          $line=149;
                                          $result="Err";
                                          if (true) break $try;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=151;
      $rethrow(new RuntimeException("The function \"\u03B4(state:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"\u03B4",$line);
    }
    return $result;
  }
  public static Object g(Object q) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=157;
      $result="";
      if (true) break $try;
      $line=158;
      $rethrow(new RuntimeException("The function \"g(q:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"g",$line);
    }
    return $result;
  }
  public static Object h(Object q, Object \u03C3) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=161;
      String s=null;
      s=$defaultValue(String.class);
      $line=162;
      s=$cast(String.class,$fix((($bool($opEqualY(\u03C3,'\n')))?("\\n"):($opAdditY("",\u03C3)))));
      $line=164;
      if ($opMembrY(q,preOps)) {
        $line=165;
        if (($opMembrY(\u03C3,skipChars)&&$opMembrY(q,allSymbols))) {
          $line=166;
          ((gold.structures.list.GArrayList)images).add(currentString);
          $line=167;
          currentString=$cast(String.class,$fix(""));
          $line=168;
          $result=Lexer202220.translationGet(q);
          if (true) break $try;
        }
        else {
          $line=169;
          if ($opMembrY($opAdditY(q,\u03C3),preOps)) {
            $line=170;
            currentString=$cast(String.class,$fix($opAdditY(currentString,s)));
            $line=171;
            $result="";
            if (true) break $try;
          }
          else {
            $line=172;
            if (($opMembrY(\u03C3,$opUnionY(StartOps,alphaNum))&&$opMembrY(q,allSymbols))) {
              $line=173;
              ((gold.structures.list.GArrayList)images).add(currentString);
              $line=174;
              currentString=$cast(String.class,$fix($opAdditY("",s)));
              $line=175;
              $result=Lexer202220.translationGet(q);
              if (true) break $try;
            }
            else {
              $line=176;
              if ($opMembrY(\u03C3,$opUnionY($opUnionY($opUnionY(StartOps,alphaNum),skipChars),GCollections.asSet(':')))) {
                $line=177;
                currentString=$cast(String.class,$fix($opAdditY("",s)));
                $line=178;
                $result=Lexer202220.translationPreOps(q);
                if (true) break $try;
              }
              else {
                $line=180;
                currentString=$cast(String.class,$fix($opAdditY(currentString,s)));
                $line=181;
                $result="";
                if (true) break $try;
              }
            }
          }
        }
      }
      else {
        $line=185;
        if ((!$opMembrY(q,GCollections.asSet("Err"))&&$opMembrY(\u03C3,$opUnionY(skipChars,StartOps)))) {
          $line=186;
          if ($opEqualY(q,"INIT")) {
            $line=187;
            currentString=$cast(String.class,$fix((($bool($opMembrY(\u03C3,StartOps)))?(s):(""))));
            $line=188;
            $result="";
            if (true) break $try;
          }
          else {
            $line=189;
            if ($opEqualY(Lexer202220.translationGet(q),null)) {
              $line=191;
              ((gold.structures.list.GArrayList)images).add(currentString);
              $line=192;
              currentString=$cast(String.class,$fix((($bool($opMembrY(\u03C3,$opUnionY(skipChars,StartOps))))?(s):(""))));
              $line=193;
              Object f=$fix($invokeMethod("charAt",q,new Object[]{0}));
              $line=194;
              if ($opMembrY(f,alphaUpper)) {
                $line=194;
                $result=Lexer202220.translationGet("IdU");
                if (true) break $try;
              }
              else {
                $line=195;
                if ($opMembrY(f,alphaLower)) {
                  $line=196;
                  $result=Lexer202220.translationGet("IdL");
                  if (true) break $try;
                }
                else {
                  $line=197;
                  $result=null;
                  if (true) break $try;
                }
              }
            }
            else {
              $line=200;
              ((gold.structures.list.GArrayList)images).add(currentString);
              $line=201;
              currentString=$cast(String.class,$fix((($bool($opMembrY(\u03C3,$opUnionY(skipChars,StartOps))))?(s):(""))));
              $line=202;
              $result=Lexer202220.translationGet(q);
              if (true) break $try;
            }
          }
        }
        else {
          $line=205;
          currentString=$cast(String.class,$fix($opAdditY(currentString,s)));
          $line=206;
          $result="";
          if (true) break $try;
        }
      }
      $line=209;
      $rethrow(new RuntimeException("The function \"h(q:Object,\u03C3:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"h",$line);
    }
    return $result;
  }
  public static Object initialize() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=215;
      skipChars=$cast(ISet.class,$fix(GCollections.asSet(' ','\t','\n')));
      $line=216;
      alphaUpper=$cast(ISet.class,$fix($opIntvlY('A','Z')));
      $line=217;
      alphaLower=$cast(ISet.class,$fix($opIntvlY('a','z')));
      $line=218;
      digits=$cast(ISet.class,$fix($opIntvlY('0','9')));
      $line=219;
      alphaNum=$cast(ISet.class,$fix($opUnionY($opUnionY($opUnionY(alphaUpper,alphaLower),digits),GCollections.asSet(':','='))));
      $line=221;
      keyWords=$cast(ISet.class,$fix(GCollections.asSet("PROG","GORP","var","PROC","CORP","walk","jump","jumpTo","veer","look","drop","grab","get","free","pop","if","else","fi","while","do","od","repeatTimes","per","isFacing","isValid","canWalk","not","north","south","east","west","right","left","front","back","around")));
      $line=225;
      allSymbols=$cast(ISet.class,$fix(GCollections.asSet("(",")",",",":",";","{","}","=")));
      $line=235;
      ((gold.structures.map.GHashTableMap)translation).put("fi",'a');
      $line=236;
      ((gold.structures.map.GHashTableMap)translation).put("do",'b');
      $line=237;
      ((gold.structures.map.GHashTableMap)translation).put("CORP",'c');
      $line=238;
      ((gold.structures.map.GHashTableMap)translation).put("else",'d');
      $line=239;
      ((gold.structures.map.GHashTableMap)translation).put("veer",'e');
      $line=240;
      ((gold.structures.map.GHashTableMap)translation).put("front",'f');
      $line=241;
      ((gold.structures.map.GHashTableMap)translation).put("back",'f');
      $line=242;
      ((gold.structures.map.GHashTableMap)translation).put("GORP",'g');
      $line=243;
      ((gold.structures.map.GHashTableMap)translation).put("while",'h');
      $line=244;
      ((gold.structures.map.GHashTableMap)translation).put("if",'i');
      $line=246;
      ((gold.structures.map.GHashTableMap)translation).put("jump",'j');
      $line=247;
      ((gold.structures.map.GHashTableMap)translation).put("drop",'j');
      $line=248;
      ((gold.structures.map.GHashTableMap)translation).put("grab",'j');
      $line=249;
      ((gold.structures.map.GHashTableMap)translation).put("get",'j');
      $line=250;
      ((gold.structures.map.GHashTableMap)translation).put("free",'j');
      $line=251;
      ((gold.structures.map.GHashTableMap)translation).put("pop",'j');
      $line=253;
      ((gold.structures.map.GHashTableMap)translation).put("canWalk",'k');
      $line=255;
      ((gold.structures.map.GHashTableMap)translation).put("look",'l');
      $line=256;
      ((gold.structures.map.GHashTableMap)translation).put("repeatTimes",'m');
      $line=257;
      ((gold.structures.map.GHashTableMap)translation).put("around",'n');
      $line=258;
      ((gold.structures.map.GHashTableMap)translation).put("od",'o');
      $line=259;
      ((gold.structures.map.GHashTableMap)translation).put("PROG",'p');
      $line=260;
      ((gold.structures.map.GHashTableMap)translation).put("isValid",'q');
      $line=261;
      ((gold.structures.map.GHashTableMap)translation).put("PROC",'r');
      $line=262;
      ((gold.structures.map.GHashTableMap)translation).put("per",'s');
      $line=263;
      ((gold.structures.map.GHashTableMap)translation).put("jumpTo",'t');
      $line=264;
      ((gold.structures.map.GHashTableMap)translation).put("not",'u');
      $line=265;
      ((gold.structures.map.GHashTableMap)translation).put("var",'v');
      $line=266;
      ((gold.structures.map.GHashTableMap)translation).put("walk",'w');
      $line=268;
      ((gold.structures.map.GHashTableMap)translation).put("north",'x');
      $line=269;
      ((gold.structures.map.GHashTableMap)translation).put("south",'x');
      $line=270;
      ((gold.structures.map.GHashTableMap)translation).put("east",'x');
      $line=271;
      ((gold.structures.map.GHashTableMap)translation).put("west",'x');
      $line=273;
      ((gold.structures.map.GHashTableMap)translation).put("right",'y');
      $line=274;
      ((gold.structures.map.GHashTableMap)translation).put("left",'y');
      $line=276;
      ((gold.structures.map.GHashTableMap)translation).put("isFacing",'z');
      $line=283;
      ((gold.structures.map.GHashTableMap)translation).put("Num",'#');
      $line=284;
      ((gold.structures.map.GHashTableMap)translation).put("IdL",'*');
      $line=285;
      ((gold.structures.map.GHashTableMap)translation).put("IdU",'*');
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,Lexer202220.class,"initialize",$line);
    }
    return $result;
  }
}
