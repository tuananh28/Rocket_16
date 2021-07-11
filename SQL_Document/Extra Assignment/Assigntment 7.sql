DROP DATABASE IF EXISTS Assignment_7;
CREATE DATABASE Assignment_7;
USE Assignment_6;

DROP TRIGGER IF EXISTS Ex1;
DELIMITER $$
CREATE TRIGGER Ex1
    BEFORE INSERT ON `project_modules`
    FOR EACH ROW
    BEGIN
        DECLARE v_ProjectModulesDate DATETIME DEFAULT NOW();
        DECLARE v_ProjetcModulesCompleteOn DATETIME DEFAULT NOW();
        SELECT  ProjectStartDate, ProjetcCompleteOn  INTO v_ProjectModulesDate,v_ProjetcModulesCompleteOn
        FROM    `projects`
        WHERE projects.ProjectID = NEW.ProjectID;
        IF(NEW.ProjectModulesDate <= v_ProjectModulesDate AND NEW.ProjetcModulesCompleteOn >= v_ProjetcModulesCompleteOn) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = 'Ban nhap sai';
        end if ;
    END $$
DELIMITER ;
INSERT INTO `project_modules` (ProjectID, EmployeeID, ProjectModulesDate, ProjetcModulesCompleteOn, ProjectModulesDescription)
VALUES                        (    1    ,       1   ,   '2021-06-02'    ,   '2021-07-08'          ,     'Thiết kế Tủ bếp');

SELECT * from `project_modules`;


USE `fresher`;
CREATE OR REPLACE VIEW `TTS` AS
    SELECT *
    FROM    trainee
    WHERE   (ET_IQ + ET_Gmath)>=20
    AND ET_IQ>=8
    AND ET_Gmath>=8
    AND  ET_English>=18;

SELECT * FROM TTS;
