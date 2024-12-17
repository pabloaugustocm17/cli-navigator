package com.yaxx.navigator;

import com.yaxx.navigator.initializer.Metadata;
import com.yaxx.navigator.interpreter.Project;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class NavigatorApplication {

	public static void main(String[] args) {

		Metadata metadata = new Metadata();

		Hashtable<String, Method> table_metadata = metadata.createOptionsMetadata();

		String enter_line = args[0];

		if (enter_line.equals("-c")) {

			executeCommandWithOneParam("createProject", metadata.FOLDER_PROJECTS, table_metadata);

			return;
		}

		if (enter_line.equals("-l")) {

			executeCommandWithOneParam("listProject", metadata.FOLDER_PROJECTS, table_metadata);

			return;
		}

		if (enter_line.contains("-e")) {

			String params[] = new String[2];

			params[0] = metadata.FOLDER_PROJECTS;
			params[1] = args[1];

			executeCommandWithTwoParam("enterProject", params, table_metadata);

			return;
		}

		if (enter_line.contains("-d")) {

			String params[] = new String[2];

			params[0] = metadata.FOLDER_PROJECTS;
			params[1] = args[1];

			executeCommandWithTwoParam("deleteProject", params, table_metadata);

			return;
		}
	}

	private static void executeCommandWithOneParam(String command, String param, Hashtable<String, Method> table) {

		Method method = table.get(command);

		try {
			method.invoke(Project.class, param);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void executeCommandWithTwoParam(String command, String[] params, Hashtable<String, Method> table) {

		Method method = table.get(command);

		try {
			method.invoke(Project.class, params[0], params[1]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
