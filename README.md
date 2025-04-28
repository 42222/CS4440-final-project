# Java Parallel Image Processor

## Project Overview
This is a Java desktop application that allows users to:
- Upload an image
- Apply filters like **greyscale** (more filters may be added)
- Process different sections of the image **in parallel using multiple threads**
- Compare thread execution times

The goal is to demonstrate **parallel processing** and **multithreading** concepts using image manipulation as a practical example.

---

##Basic Structure

```
JavaParallelImageProcessor/
├── images/                # Folder to hold sample images
├── src/                    # Java source code
│   ├── Main.java           # Program entry point
│   ├── ImageProcessor.java # Image filter logic (e.g., greyscale)
│   ├── ThreadedImageProcessor.java # Thread logic to process parts of image
│   └── Utils.java          # Helper methods (loading/saving images)
├── .gitignore              # Ignore class files and IDE settings
└── README.md               # Project overview (this file)
```

---

## ⚙️ How to Run

1. Clone or download this repository.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Compile and run `Main.java`.
4. (Later) Select an image to apply filters.

---

##To-Do

- [x] Set up basic file structure
- [ ] Implement image loading and saving
- [ ] Implement greyscale filter
- [ ] Split image into sections and process with threads
- [ ] Measure and compare thread execution times
- [ ] Add more filters if time allows

---

##Notes
- This project is part of **CS4440 Final Project**.
- It focuses on **Java multithreading** and **image processing basics**.
