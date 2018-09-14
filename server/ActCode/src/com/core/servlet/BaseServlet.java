package com.core.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.util.LogUtil;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 4948409059400291790L;

	/** 初始化 */
	public void initReqResp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		resp.setStatus(HttpServletResponse.SC_OK);
	}

	/** 解析消息 */
	public JSONObject dealMsg(HttpServletRequest req) {

		JSONObject jsonObject = null;
		OutputStream os = null;
		InputStream is = null;
		try {
			String msg = null;

			os = new ByteArrayOutputStream();
			is = req.getInputStream();
			if (is != null) {
				byte[] b = new byte[1024];
				int len = 0;
				while ((len = is.read(b)) != -1) {
					os.write(b,0,len);
				}
				msg = os.toString();
			}

			jsonObject = new JSONObject(msg);
		} catch (Exception e) {
			LogUtil.error("异常:",e);
			return null;
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				LogUtil.error("异常:",e);
			}
		}

		return jsonObject;
	}
}
