package com.giouxel.maze.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.giouxel.maze.model.Coordinate;
import com.giouxel.maze.model.Maze;
import com.giouxel.maze.service.FileService;
import com.giouxel.maze.util.BreadthFirstSearch;
import com.giouxel.maze.util.DepthFirstSearch;

@Controller
public class FileUploadController {
	
	private FileService fileService;
	
	public FileUploadController(FileService fileService) {
		this.fileService = fileService;
	}

	@GetMapping("/")
	public String fileupload() {
		return "fileUpload";
	}
	
	@PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		
		try {
			InputStream inputStream = file.getInputStream();
			String mazeInput = fileService.readFromInputStream(inputStream);
			System.out.println();
			System.out.println("Initial maze input:");
			System.out.println();
			System.out.println(mazeInput);
			System.out.println();
			
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded " + file.getOriginalFilename() + "!");
			redirectAttributes.addFlashAttribute("message2",
					"Processing the maze...");
	        
			
			Maze maze = new Maze();
			maze.initializeMaze(mazeInput);
			
	        DepthFirstSearch dfs = new DepthFirstSearch();
	        List<Coordinate> pathD = dfs.solve(maze);
	        
	        System.out.println("Depth First Search output:");
	        System.out.println();
	        System.out.println(maze.drawPath(pathD));
	        System.out.println();
	        
	        maze.printPath(pathD);
	        maze.reset();
	        
	        BreadthFirstSearch bfs = new BreadthFirstSearch();
	        List<Coordinate> pathB = bfs.solve(maze);
	        
	        System.out.println("Breadth First Search output:");
	        System.out.println();
	        List<Coordinate> pathReversed = new ArrayList<Coordinate>();
	        pathReversed.addAll(pathB);
	        Collections.reverse(pathReversed);
	        System.out.println(maze.drawPath(pathReversed));
	        System.out.println();
	        
	        maze.printPath(pathB);
	        maze.reset();
			
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("message",
					"GOT I/O EXCEPTION!");
			e.printStackTrace();
		}

		return "redirect:/";
	}
}
