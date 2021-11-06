# Design-Pattern

同济大学软件学院 2021-2022 学年第 1 学期设计模式课程小组项目

## 项目依赖

`JDK >= 11`

`Maven`

`IntelliJ IDEA`

## 运行方式

本项目支持两种运行方式

1. 正常运行

2. 运行测试

### 在命令行环境下正常运行

### 在 IntelliJ IDEA 中正常运行

### 在命令行环境下运行测试

1. 获取项目源码。
2. 确保 `Maven` 配置完毕并可用。可以参照 [Maven - Install](https://maven.apache.org/install.html)。在 [这里](https://maven.apache.org/download.cgi) 下载 `Maven`。
3. 在项目根目录打开 shell，执行 `mvn install`。`Maven` 会帮助你打包并运行所有的测试。
4. 等待并检查输出。

运行成功输出：

![截屏2021-11-06 下午8.10.38](https://tva1.sinaimg.cn/large/008i3skNly1gw5p4uw8z5j310a0d8god.jpg)

### 在 IntelliJ IDEA 中运行测试



## 项目结构

```
Design-Pattern
├── src
│   ├── main 
│   │   ├── java	// 项目源文件
│   │   │   └── olympic
│   │   │       ├── main
│   │   │       │   ├── director
│   │   │       │   ├── drawlots
│   │   │       │   ├── game
│   │   │       │   │   ├── badminton
│   │   │       │   │   ├── basketball
│   │   │       │   │   │   └── round
│   │   │       │   │   ├── diving
│   │   │       │   │   ├── football
│   │   │       │   │   │   └── round
│   │   │       │   │   ├── pingponggame
│   │   │       │   │   ├── track
│   │   │       │   │   └── volleyball
│   │   │       │   │       └── round
│   │   │       │   ├── interview
│   │   │       │   │   ├── builder
│   │   │       │   │   └── questionstrategy
│   │   │       │   ├── opening
│   │   │       │   │   ├── deliverspeech
│   │   │       │   │   ├── enterarena
│   │   │       │   │   ├── fireworkshow
│   │   │       │   │   ├── performance
│   │   │       │   │   ├── protectionfactory
│   │   │       │   │   ├── ticketchecking
│   │   │       │   │   └── translate
│   │   │       │   ├── person
│   │   │       │   │   ├── athlete
│   │   │       │   │   │   ├── badminton
│   │   │       │   │   │   │   └── strategy
│   │   │       │   │   │   ├── basketballathlete
│   │   │       │   │   │   ├── divingathlete
│   │   │       │   │   │   ├── footballathlete
│   │   │       │   │   │   ├── pingong
│   │   │       │   │   │   │   └── strategy
│   │   │       │   │   │   ├── torchbarer
│   │   │       │   │   │   ├── track
│   │   │       │   │   │   └── volleyballathlete
│   │   │       │   │   ├── athleteList
│   │   │       │   │   │   └── urineTestProcurator
│   │   │       │   │   ├── interview
│   │   │       │   │   ├── personvisitor
│   │   │       │   │   │   └── visitFilterChain
│   │   │       │   │   └── volunteer
│   │   │       │   │       └── state
│   │   │       │   ├── postgame
│   │   │       │   │   ├── awardceremony
│   │   │       │   │   │   ├── factory
│   │   │       │   │   │   ├── medaldecorator
│   │   │       │   │   │   ├── olympicmedalfactory
│   │   │       │   │   │   └── prototypeframework
│   │   │       │   │   ├── chores
│   │   │       │   │   ├── medaltable
│   │   │       │   │   ├── monitorsite
│   │   │       │   │   └── reviewqualification
│   │   │       │   ├── precompetitionsystem
│   │   │       │   │   └── urinetest
│   │   │       │   └── pressconference
│   │   │       │       └── questionstrategy
│   │   │       ├── picture
│   │   │       ├── scene
│   │   │       ├── utils
│   │   │       └── voiceover
│   │   └── resources	// 资源文件
│   │       ├── person
│   │       ├── picture
│   │       └── voiceover
│   └── test	// 测试
│       └── java
│           └── olympic
│               └── scene
├── .gitignore  // git 配置文件
├── pom.xml     // maven 配置文件
└── README.md   // 本文档

74 directories, 318 files
```

