# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.7

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /usr/bin/cmake

# The command to remove a file.
RM = /usr/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build

# Include any dependencies generated for this target.
include CMakeFiles/t-eval.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/t-eval.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/t-eval.dir/flags.make

CMakeFiles/t-eval.dir/t-eval.cpp.o: CMakeFiles/t-eval.dir/flags.make
CMakeFiles/t-eval.dir/t-eval.cpp.o: /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test/t-eval.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/t-eval.dir/t-eval.cpp.o"
	/usr/bin/c++   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/t-eval.dir/t-eval.cpp.o -c /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test/t-eval.cpp

CMakeFiles/t-eval.dir/t-eval.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/t-eval.dir/t-eval.cpp.i"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test/t-eval.cpp > CMakeFiles/t-eval.dir/t-eval.cpp.i

CMakeFiles/t-eval.dir/t-eval.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/t-eval.dir/t-eval.cpp.s"
	/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test/t-eval.cpp -o CMakeFiles/t-eval.dir/t-eval.cpp.s

CMakeFiles/t-eval.dir/t-eval.cpp.o.requires:

.PHONY : CMakeFiles/t-eval.dir/t-eval.cpp.o.requires

CMakeFiles/t-eval.dir/t-eval.cpp.o.provides: CMakeFiles/t-eval.dir/t-eval.cpp.o.requires
	$(MAKE) -f CMakeFiles/t-eval.dir/build.make CMakeFiles/t-eval.dir/t-eval.cpp.o.provides.build
.PHONY : CMakeFiles/t-eval.dir/t-eval.cpp.o.provides

CMakeFiles/t-eval.dir/t-eval.cpp.o.provides.build: CMakeFiles/t-eval.dir/t-eval.cpp.o


# Object files for target t-eval
t__eval_OBJECTS = \
"CMakeFiles/t-eval.dir/t-eval.cpp.o"

# External object files for target t-eval
t__eval_EXTERNAL_OBJECTS =

t-eval: CMakeFiles/t-eval.dir/t-eval.cpp.o
t-eval: CMakeFiles/t-eval.dir/build.make
t-eval: CMakeFiles/t-eval.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable t-eval"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/t-eval.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/t-eval.dir/build: t-eval

.PHONY : CMakeFiles/t-eval.dir/build

CMakeFiles/t-eval.dir/requires: CMakeFiles/t-eval.dir/t-eval.cpp.o.requires

.PHONY : CMakeFiles/t-eval.dir/requires

CMakeFiles/t-eval.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/t-eval.dir/cmake_clean.cmake
.PHONY : CMakeFiles/t-eval.dir/clean

CMakeFiles/t-eval.dir/depend:
	cd /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/test /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build /etudiants/tboitel/Documents/Verel/firing-squad-synchronization-problem-master/build/CMakeFiles/t-eval.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/t-eval.dir/depend

