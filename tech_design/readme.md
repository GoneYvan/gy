
### 模块定义
    * basic 基础支持模块 -- 日志服务
    * service 服务层 -- 数据库实现以及服务接口提供
    * origin 插件层 -- 如：redis支持，rabbitMQ等
    * rest api层 -- 对外提供接口






TODO：
    问题：数据逻辑删除存在唯一性判断时需要手动添加校验,如为已删除用户重建一份资料，但是用户身份ID唯一
    解决方案：一：删除数据进行备份后物理删除。二：每次进行新增时候增加唯一性判断
    
    问题：目前的分层模式，当数据出现逻辑或物理失败时无法准确反馈错误原因
    解决方案：重构底层DAO且增设错误反馈机制，如自定义错误异常机制以及逻辑错误返回信息库

    问题：redis key值校验：添加重复key值，无法识别是new key or modify old key
    解决方案：暂时采用人工避免
