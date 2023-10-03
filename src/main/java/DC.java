
import java.io.*;
import java.util.*;
import java.util.Random;

import javax.servlet.http.*;

public class DC extends HttpServlet
{
	
	public static HashMap<Integer, String> GSC = new HashMap<>();// General Status Codes
	
	static
	{
		GSC.put(100, "Continue");
		GSC.put(101, "Switching Protocols" );
		GSC.put(102, "Processing");
		GSC.put(103, "Early Hins");
		
		GSC.put(200, "OK");
		GSC.put(201, "Created");
		GSC.put(202, "Accepted");
		GSC.put(203, "Non-Authoritative Information");
		GSC.put(204, "No Content");
		GSC.put(205, "Reset Content");
		GSC.put(206, "Partial Content");
		GSC.put(207, "Multi-Status");
		GSC.put(208, "Alredy Reported");
		GSC.put(200, "IM Used");
		
		GSC.put(300, "Multiple choices");
		GSC.put(301, "Moved Permanently");
		GSC.put(302, "Found");
		GSC.put(303, "See Other");
		GSC.put(304, "Not Modified");
		GSC.put(305, "Use Proxy");
		GSC.put(306, "Unused");
		GSC.put(307, "Temporary Redirect");
		GSC.put(308, "Temporary Redirect");
		
		GSC.put(400, "Bad Request");
		GSC.put(401, "Unauthorized");
		GSC.put(402, "Payment Required");
		GSC.put(403, "Forbidden");
		GSC.put(404, "Not Found");
		GSC.put(405, "Method Not Allowed");
		GSC.put(406, "Not Acceptable");
		GSC.put(407, "Proxy Authentication Required");
		GSC.put(408, "Request Timeout");
		GSC.put(409, "Conflict");
		GSC.put(410, "Gone");
		GSC.put(411, "Length Required");
		GSC.put(412, "Precondition Failed");
		GSC.put(413, "Payload Too Large");
		GSC.put(414, "URI Too Long");
		GSC.put(415, "Unsupported Media Type");
		GSC.put(416, "Range Not Satisfiable");
		GSC.put(417, "Expected Failed");
		GSC.put(418, "I'm a teapot");
		GSC.put(421, "Misdirected Request");
		GSC.put(422, "Unprocessable Content");
		GSC.put(423, "Locked");
		GSC.put(424, "Failed Dependency");
		GSC.put(425, "Too Early");
		GSC.put(426, "Upgrade Required");
		GSC.put(428, "Precondition Required");
		GSC.put(429, "Too Many Requests");
		GSC.put(431, "Request Header Fields Too Large");
		GSC.put(451, "Unavailable For Legal Reasons");
		
		GSC.put(500, "Internal Server Error");
		GSC.put(501, "Not Implemented");
		GSC.put(502, "Bad Gateway");
		GSC.put(503, "service Unaviable");
		GSC.put(504, "Gateway Timeout");
		GSC.put(505, "HTTP Version Not Supported");
		GSC.put(506, "Variant Also Negotiates");
		GSC.put(507, "Insufficient Storage");
		GSC.put(508, "Loop Detected");
		GSC.put(510, "Not Extended");
		GSC.put(511, "Network Authentication Required");
		
	}
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		
		int sc = new Random().nextInt(500)+100;// Status Code
		String m = new String();// Message
		if(GSC.containsKey(sc))
		{
			m = GSC.get(sc);
		}
		else
		{
			int r = sc/100;
			if(r == 1)     { m = "Information responses";  } 
			else if(r == 2){ m = "Successful responses";   }
			else if(r == 3){ m = "Redirection messages";   }
			else if(r == 4){ m = "Client error responses"; }
			else if(r == 5){ m = "Server error responses"; }
		}
		
		DB_Connection obj = new DB_Connection(m,sc);
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		
		out.println("<b>");
		
		out.println("<H4>");
		out.print("HTTP RESPONSE STATUS CODE ");	
		out.print("</H4>");
		
		out.println("<H1>");
		out.print(sc);
		out.println("</H1>");
		
		out.println("<H4>");
		out.print(" MESSAGE: ");	
		out.print("</H4>");
		
		out.print("<H1>");
		out.print(m);
		out.print("</H1>");
		
		out.print("</b>");
		
		out.print("<br>");
		out.print("<br>");
		
		out.print("<H1>");
		try {
			out.print(obj.toDB());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("</H1>");
		
		out.println("</body>");
		out.println("</html>");
		//)
		
	}	
}
