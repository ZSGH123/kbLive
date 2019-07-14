#20190713
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_password` varchar(50) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_realname` varchar(50) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_sex` varchar(4) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_idcard` varchar(18) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_weibo_id` varchar(40) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_qq_id` varchar(40) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_icon` varchar(500) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_alipay` varchar(40) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_bank_card` varchar(40) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `status`  tinyint(1) NULL DEFAULT 1 ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `create_date` datetime(0) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `login_times` int(20) NULL DEFAULT 0 ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `last_login_date` datetime(0) NULL ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `modify_date` datetime(0) NULL ON UPDATE CURRENT_TIMESTAMP(0) ;
ALTER TABLE `kblive`.`kblive_user` ADD COLUMN `user_note` varchar(500) NULL ;