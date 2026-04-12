SELECT O.ANIMAL_ID, O.NAME 
FROM ANIMAL_OUTS O 
WHERE O.ANIMAL_ID NOT IN (SELECT I.ANIMAL_ID 
                          FROM ANIMAL_INS I 
                          INNER JOIN ANIMAL_OUTS O 
                          ON I.ANIMAL_ID = O.ANIMAL_ID 
                          ORDER BY I.ANIMAL_ID);




