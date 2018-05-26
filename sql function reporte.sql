CREATE OR REPLACE FUNCTION fn_listarResumen (param_x INT) 
 RETURNS TABLE (
 cantidad INT,
 fecha TEXT
) 
AS $$
DECLARE 
    var_r record;
BEGIN
FOR var_r IN(
	select (count(*)::int) as cantidad, to_char(c.fecha, 'dd/MM/yyyy') as fecha from consulta c 
	where id_medico = param_x
	group by c.fecha order by c.fecha asc 
	)  
 LOOP
        cantidad := var_r.cantidad; 
 		fecha := var_r.fecha;
        RETURN NEXT;
 END LOOP;
END; $$ 
LANGUAGE 'plpgsql';


--select * from fn_listarResumen(1);