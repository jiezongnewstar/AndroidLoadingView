Android 网络加载以及耗时操作的指示器动画。

gradle 添加依赖 compile 'cn.jiajie.loading:load:1.0'

maven ：
<dependency> 
    <groupId>cn.jiajie.loading</groupId> 
    <artifactId>load</artifactId> 
    <version>1.0</version> 
    <type>pom</type> 
</dependency>


简单的使用 

new LoadingDialog.Buidler(context).loadtext("needed String").build().show()
