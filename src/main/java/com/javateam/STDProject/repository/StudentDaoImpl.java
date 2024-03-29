package com.javateam.STDProject.repository;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javateam.STDProject.domain.StudentVO;
import com.javateam.STDProject.dao.StudentMapper;

@Repository
@Primary
public class StudentDaoImpl implements StudentRepository{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
	    this.sqlSession = (SqlSessionTemplate) sqlSession;
	 }
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
		new JdbcTemplate(dataSource);
    }
	
//    @Override
//	public void insert(StudentVO vo) {
//    	String SQL = "insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board ),?,?,?)";
//
//    	try {
//    		StudentVO vo = this.jdbcTemplate
//    						   .queryForObject(SQL)
//    	pstmt=conn.prepareStatement(SQL);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(pstmt, conn);
//		}
//	}
//
//	@Override
//	public void update(StudentVO vo) {
//		try {
//			conn = jdbc.getConnection();
//			String SQL = "update Board set title=? , writer=?, content=? where seq=?";
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getWriter());
//			pstmt.setString(3, vo.getContent());
//			pstmt.setInt(4, vo.getSeq());
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(pstmt, conn);
//		}
//	}
//
//	@Override
//	public void delete(int seq) {
//		System.out.println("dao1 : " + seq);
//		try {
//			conn = jdbc.getConnection();
//			String SQL = " delete from Board where seq = ? ";
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, seq);
//			pstmt.executeUpdate();
//			System.out.println("dao");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally{
//			jdbc.close(pstmt, conn);
//		}
//	}
//
//	@Override
//	public StudentVO getBoard(int seq) {
//		String SQL = " select * from Board where seq = ? ";
//		try {
//			StudentVO vo = (StudentVO)this.jdbcTemplate
//							   .queryForObject(SQL,
//									   		   new BeanPropertyRowMapper<Users>(Users.class),
//					   				           new Object[]{ username })
//			if(rs.next()) {
//				board = new StudentVO();
//				board.setSeq(rs.getInt("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getDate("regdate"));
//				board.setCnt(rs.getInt("cnt"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(rs,pstmt, conn);
//		}
//		return board;
//	}
//
	@Override
	public List<StudentVO> getBoardList(StudentVO vo) {
		List<StudentVO> li = new ArrayList<StudentVO> ();
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		li = studentMapper.getBoardList();
		
		return li;
	}

@Override
public void insert(StudentVO vo) {
	// TODO Auto-generated method stub
	
}

@Override
public void update(StudentVO vo) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(int seq) {
	// TODO Auto-generated method stub
	
}

@Override
public StudentVO getBoard(int seq) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<StudentVO> getBoardList() {
	// TODO Auto-generated method stub
	return null;
}

//@Override
//public Iterable<StudentVO> findAll(Sort sort) {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//@Override
//public Page<StudentVO> findAll(Pageable pageable) {
//	// TODO Auto-generated method stub
//	return null;
//}

@Override
public void cnt(int seq) {
	// TODO Auto-generated method stub
	
}

@Override
public int totalCount() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int totalCount2() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public List<StudentVO> getBoardList2(StudentVO vo) {
	// TODO Auto-generated method stub
	return null;
}

//
//	//조회수 올라가게 함. 
//	@Override
//	public void cnt(int seq) {
//		try {
//			conn = jdbc.getConnection();
//			String SQL= " update board set cnt=cnt+1 where seq = ? ";
//			pstmt = conn.prepareStatement(SQL);
//			pstmt.setInt(1, seq);
//			pstmt.executeLargeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(pstmt, conn);
//		}
//		
//		
//	}
//
//	//총 조회수
//	@Override
//	public int totalCount() {
//		int tc = 0 ;
//		try {
//			conn = jdbc.getConnection();
//			String SQL = "select count(*) tc from board"; // tc = totalCount! as로 이름 준거임.
//			pstmt = conn.prepareStatement(SQL);
//			rs=pstmt.executeQuery();
//			if(rs.next()) {
//				tc=rs.getInt("tc");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(rs, pstmt, conn);
//		}
//		return tc;
//	}
//	
//	// 총 페이지
//	@Override
//	public int totalCount2() {
//		StudentVO vo ;
//		int tc = 0;
//		
//		try {
//			vo = new StudentVO();
//			conn = jdbc.getConnection();
//			if (vo.getCh1() == null ) {
//				String SQL = "select  count(*) tc  from board "; // tc = totalCount as로 이름 준 것. 
//				pstmt=conn.prepareStatement(SQL);	
//			}else if(vo.getCh1().equals("title")) {
//				String SQL = "select  count(*) tc  from board where title like ? ";
//				pstmt=conn.prepareStatement(SQL);
//				pstmt.setString(1, "%"+vo.getCh2Text()+"%");
//			}else if(vo.getCh1().equals("writer")) {
//				String SQL = "select  count(*) tc  from board where writer like ?  ";
//				pstmt=conn.prepareStatement(SQL);	
//				pstmt.setString(1, "%"+vo.getCh2Text()+"%");
//			}
//			rs=pstmt.executeQuery();		
//			if(rs.next()) {				
//				tc=rs.getInt("tc");				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(rs , pstmt, conn);
//		} 
//		return tc;
//	}
//
//
//	//페이지 
//	@Override
//	public List<StudentVO> getBoardList2(StudentVO vo) {
//
//		String SQL ="";		
//		String SQL2 ="";		
//		
//		List<StudentVO> li=new ArrayList<StudentVO>();
//		try {
//			conn = jdbc.getConnection();
//			
//			SQL = " select  rownum, Q.* from ( select rownum as rnum, K.*  from  " ;
//			SQL2= " where  rownum <= ?  )Q  where rnum >= ?  " ;  
//			
//			if (vo.getCh1() == null  || vo.getCh1().equals("null") && vo.getCh2Text().equals("null") ) {
//				
//		         SQL = SQL + " ( select seq,title,writer,content,cnt,regdate  from board order  by  seq  asc ) K   " ; 
//		         SQL = SQL + SQL2 ;
//		         
//				pstmt=conn.prepareStatement(SQL);				
//				pstmt.setInt(1, vo.getStart() + vo.getPageSize() - 1); // 한페이지에 몇개르 ㄹ보여줄 건지 10개 보여줌 
//				pstmt.setInt(2, vo.getStart()); // 해당 페이지의 처음 rownum/ 1~10 이면 1부터, / 11~20이면 11부터. 
//				
//			} else if (vo.getCh1().equals("title")) {
//			  	
//		         SQL = SQL + " ( select seq,title,writer,content,cnt,regdate  from board  where title like ?  order  by  seq  asc ) K   " ; 
//		         SQL = SQL + SQL2 ;
//		         
//				pstmt=conn.prepareStatement(SQL);	
//				pstmt.setString(1, "%" + vo.getCh2Text() + "%");
//				pstmt.setInt(2, vo.getStart() + vo.getPageSize() - 1);
//				pstmt.setInt(3, vo.getStart());
//				
//			} else if (vo.getCh1().equals("writer")) {
//		         SQL = SQL + " ( select seq,title,writer,content,cnt,regdate  from board  where writer like ?  order  by  seq  asc ) K   " ; 
//		         SQL = SQL + SQL2 ;
//
//				pstmt=conn.prepareStatement(SQL);	
//				pstmt.setString(1, "%" + vo.getCh2Text() + "%");
//				pstmt.setInt(2, vo.getStart() + vo.getPageSize() - 1);
//				pstmt.setInt(3, vo.getStart());
//				
//			} else {
//				SQL = SQL + " ( select seq,title,writer,content,cnt,regdate  from board where title like ? or writer like ? order  by  seq  asc ) K   " ; 
//				SQL = SQL + SQL2 ;
//				
//				pstmt=conn.prepareStatement(SQL);				
//				pstmt.setString(1, "%" + vo.getCh2Text() + "%");
//				pstmt.setString(2, "%" + vo.getCh2Text() + "%");
//				pstmt.setInt(3, vo.getStart() + vo.getPageSize() - 1); // 한페이지에 몇개르 ㄹ보여줄 건지 10개 보여줌 
//				pstmt.setInt(4, vo.getStart()); // 해당 페이지의 처음 rownum/ 1~10 이면 1부터, / 11~20이면 11부터. 
//				
//			}
//						  
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				StudentVO	board=new StudentVO();
//				board.setSeq(rs.getInt("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setRegDate(rs.getDate("regdate"));
//				board.setCnt(rs.getInt("cnt"));
//				li.add(board);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			jdbc.close(rs , pstmt, conn);
//		} 
//		return li;
//		
//	}

	

}
