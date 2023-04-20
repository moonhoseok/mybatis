package mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import main.Student;

public interface StudentMapper2 {
	
	@Select({"<script>",
		"select * from student",
		"<where>",
		"<if test='grade != null'>grade = #{grade}</if>",
		"<if test='height != null'>height >= #{height}</if>",
		"</where>",
		"</script>"})
	List<Student> select(Map<String, Object> map);
	@Select({"<script>",
			"select * from student",
			"<where>",
			"<choose>",
			"<when test='height != null and "
			+ " grade != null '> height>=#{height} and grade=#{grade}</when>",
			"<when test='grade != null'> grade=#{grade}</when>",
			"<when test='height != null'> height>=#{height}</when>",
			"</choose>",
			"</where>",
			"</script>"})
	List<Student> select2(Map<String, Object> map);
	
}
