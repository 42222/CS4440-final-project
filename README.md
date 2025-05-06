# Java Parallel Image Processor

## 📌 Project Overview
This is a Java desktop application built as part of the **CS4440 Final Project**. It demonstrates multithreading and parallel image processing concepts through a simple but effective GUI.

### ✨ Features
- 🖼 Upload and select sample images (e.g., dog, cat, bird)
- 🎨 Apply a grayscale filter (more filters may be added)
- 🔄 Split the image into sections processed by multiple threads
- ⏱ Compare thread execution times (printed to console)
- 🖼 Display original and processed images side by side with thread divisions

---

## 📁 Project Structure



```
JavaParallelImageProcessor/
├── images/ # Folder to hold sample images (dog.png, cat.png, etc.)
├── src/ # Java source code
│ ├── Main.java # Program entry point + multithreaded processing logic
│ ├── Utils.java # Image loading/saving functions
│ ├── ImageWithGrid.java # Custom JPanel to draw image + grid lines
├── .gitignore # Ignore compiled class files, IDE configs
└── README.md # You're reading it
```

---


---

## ⚙️ How to Run

1. **Clone or Download** this repository:
    ```bash
    git clone https://github.com/42222/CS4440-final-project.git
    ```
2. **Open** in your preferred Java IDE (IntelliJ IDEA / Eclipse / VS Code).
3. **Run** `Main.java`.
4. **Select** an image from the dropdown.
5. **View** the grayscale result and processing grid.

---

## 📌 Concepts Used

- Java Multithreading (`Thread`)
- Java Swing GUI (`JFrame`, `JPanel`)
- Image manipulation with `BufferedImage`
- Performance measurement with `System.nanoTime()`

---

## ✅ Completed Tasks

- ✅ Set up basic file structure
- ✅ Implement image loading and saving (`Utils.java`)
- ✅ Add grayscale filter
- ✅ Process image in parallel by sections
- ✅ Compare thread execution times in console
- ✅ Display original + filtered image side-by-side
- ✅ Upload sample images to `/images/`

---

## 📝 To-Do (Optional Enhancements)

- [ ] Add more filter types (blur, sharpen, invert)
- [ ] Add UI buttons to select filters
- [ ] Export benchmark results to file
- [ ] Add progress bar or animation

---

## 📸 Sample Screenshots

> *(Add screenshots of your UI here if you have time)*

---

## 👨‍💻 Authors

- Project by: **[Your Name Here]**
- Course: CS4440 Final Project - Java Multithreading

---

## 📄 License

This project is for educational purposes only.
