package com.librarymanagement.controller;

import java.io.File;
import java.util.Collection;

import jakarta.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.librarymanagement.pojo.PdfView;
import com.librarymanagement.pojo.UserAccount;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 20, maxRequestSize = 1024 * 1024
		* 25)
@RequestMapping("/lms")
public class EbookController {

	private static final String FILE_DIR = System.getProperty("user.dir") + "/uploads/";

	@GetMapping("/uploadebook.htm")
	public ModelAndView uploadEbookForm(Model model, HttpServletRequest request) {

		ModelAndView mv = null;

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc == null) {
			mv = new ModelAndView("index");
		} else {
			if ("admin".equals(useracc.getRole())) {
				mv = new ModelAndView("upload-ebook");
			}
		}
		return mv;
	}

	@PostMapping("/uploadebook.htm")
	public ModelAndView uploadEbook(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession();
		UserAccount useracc = (UserAccount) session.getAttribute("useracc");

		if (useracc == null) {
			mv = new ModelAndView("index");
		} else {
			if ("admin".equals(useracc.getRole())) {

				try {
					Collection<Part> parts = request.getParts();
					for (Part part : parts) {
						if (part.getName().equals("file") && part.getSize() > 0) {
							String fileName = part.getSubmittedFileName();
							File fileSaveDir = new File(FILE_DIR);
							if (!fileSaveDir.exists()) {
								fileSaveDir.mkdirs();
							}
							part.write(FILE_DIR + fileName);

							mv = new ModelAndView("upload-success");
						}
					}
				} catch (Exception e) {
					mv = new ModelAndView("index");
				}
			}
		}

		return mv;
	}

	@GetMapping("/downloadebook.htm")
	public ModelAndView listFiles(Model model) {
		ModelAndView mv = null;
		File dir = new File(FILE_DIR);
		File[] files = dir.listFiles();
		System.out.println("files - " + files);
		mv = new ModelAndView("list-files", "files", files);
		return mv;
	}

	@GetMapping("/viewPdf")
	public ModelAndView viewPdf(@RequestParam("filename") String filename) {
		return new ModelAndView(new PdfView(), "filename", filename);
	}

}
