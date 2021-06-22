package com.viaoa.docbuilder.delegate.oa;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

import com.viaoa.docbuilder.model.oa.ClassInfo;
import com.viaoa.docbuilder.model.oa.PackageInfo;
import com.viaoa.docbuilder.model.oa.ProjectInfo;
import com.viaoa.util.OAString;

public class ProjectInfoDelegate {

	public static void loadClasses(final ProjectInfo pi) {
		if (pi == null) {
			return;
		}
		String dir = pi.getDirectory();
		if (OAString.isEmpty(dir)) {
			return;
		}

		pi.getPackageInfos().deleteAll();

		File file = new File(dir);
		if (!file.exists()) {
			return;
		}
		loadClasses(pi, null, file, null);
	}

	protected static void loadClasses(final ProjectInfo projectInfo, final PackageInfo piParent, final File fileDir,
			final String packageName) {
		String newPackageName;

		PackageInfo piNew = null;
		if (packageName != null) {
			newPackageName = OAString.concat(packageName, fileDir.getName(), ".");
			piNew = new PackageInfo();
			piNew.setPackageName(newPackageName);
			if (piParent != null) {
				piNew.setParentPackageInfo(piParent);
			} else {
				piNew.setProjectInfo(projectInfo);
			}
		} else {
			newPackageName = "";
		}

		ArrayList<File> alFile = new ArrayList<>();
		for (File f : fileDir.listFiles()) {
			if (f.isDirectory()) {
				if (f.getName().indexOf('-') < 0) {
					alFile.add(f);
				}
			}
		}

		alFile.sort(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return s1.compareTo(s2);
			}
		});

		for (File f : alFile) {
			loadClasses(projectInfo, piNew, f, newPackageName);
		}

		if (piNew == null) {
			return;
		}

		alFile = new ArrayList<>();
		for (File f : fileDir.listFiles()) {
			if (f.getName().endsWith(".java")) {
				if (f.getName().indexOf('-') < 0) {
					alFile.add(f);
				}
			}
		}
		alFile.sort(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				String s1 = o1.getName();
				String s2 = o2.getName();
				return s1.compareTo(s2);
			}
		});

		for (File f : alFile) {
			ClassInfo ci = new ClassInfo();
			ci.setName(f.getName());
			ci.setPackageInfo(piNew);
		}
	}

}
