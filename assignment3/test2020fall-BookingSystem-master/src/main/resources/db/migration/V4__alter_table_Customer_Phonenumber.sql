ALTER TABLE `testassignment`.`Customers`
    ADD COLUMN `phonenumber` VARCHAR(15) NULL DEFAULT NULL AFTER `birthdate`,
ADD UNIQUE INDEX `phonenumber_UNIQUE` (`phonenumber` ASC) VISIBLE;
;