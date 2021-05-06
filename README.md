## 编译系统 :: 实验二 - 语法分析器

### 目录结构

主程序在 `src/main/java/wang/armeria/whkcc` 目录下，其中

- `header.y` 是 bison 输入文件的头部。
- `body.y` 是 bison 输入文件的主要部分（包括文法定义）。
- `Whkcc.java` 是 bison 的输出文件。
- `WhkccLexer.java` 是继承自 `Whkcc.Lexer` 的类，主要负责读入 token。

此外，

- `c.y` 是 C99 参考文法。
- `test_simple.c` 是测试用源程序。
- `test_simple.lex` 是 `test_simple.c` 词法分析后的结果。
- `Whkcc.dot` 是自动机状态转移图。
- `Whkcc.xml` 是自动机状态转移图的 XML 表示。
- `build.sh` 是编译脚本。

### 编译运行

进入 `src/main/java/wang/armeria/whkcc` 目录，先赋予 `build.sh` 运行权限，
```shell
$ chmod +x ./build.sh
```
然后运行
```shell
$ ./build.sh -d 2
# 参数 -d 表示调试级别，默认为 1
```
即可让 bison 产生语法分析器代码 `WhkccLexer.java`。
然后在 IDE 中编译整个项目并运行 `WhkccLexer.java` 的 `main` 方法即可。
