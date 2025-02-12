# Designing Methods for Complex Data

## Goals:
- Learn to design methods for complex class hierarchies.
- Practice designing the representation of complex data.

## Problem 1: "Webpages"

Include **stubs** for the following methods:
- `totalImageSize`
- `textLength`
- `images`

### **Data Representation of Web Pages**

The following DrRacket data definition describes the contents of a webpage:

```
;; A Web Page is (make-web-page String String [Listof Item])
(define-struct web-page (title url items))

;; An Item is one of:
;; -- Text
;; -- Image
;; -- Link

;; A Text is (make-text String)
(define-struct text (contents))

;; An Image is (make-image String int String)
(define-struct image (file-name size file-type))

;; A Link is (make-link String WebPage)
(define-struct link (name page))
```

### **Class Naming Conventions**
For lists of data, follow these naming conventions:
- **Interface:** `ILo<DataType>`
- **Empty list:** `MtLo<DataType>`
- **Non-empty list:** `ConsLo<DataType>`

Examples:
- Lists of Strings: `ILoString`, `MtLoString`, `ConsLoString`
- Lists of Books: `ILoBook`, `MtLoBook`, `ConsLoBook`

---

### **Example Web Pages**
Create an `ExamplesWebPage` class with:

#### **WebPage: "Fundies II" (fundiesWP)**
**URL:** `ccs.neu.edu/Fundies2`

**Contents:**
- Text: "Home sweet home"
- Image: "wvh-lab.png", size **400**
- Text: "The staff"
- Image: "profs.jpeg", size **240**
- Link: "A Look Back" → **WebPage "HtDP"**
- Link: "A Look Ahead" → **WebPage "OOD"**

#### **WebPage: "HtDP"**
**URL:** `htdp.org`

**Contents:**
- Text: "How to Design Programs"
- Image: "htdp.tiff", size **4300**

#### **WebPage: "OOD"**
**URL:** `ccs.neu.edu/OOD`

**Contents:**
- Text: "Stay classy, Java"
- Link: "Back to the Future" → **WebPage "HtDP"**

---

## **Methods to Implement**

1. **`totalImageSize`**
   - Computes total size of all images in `fundiesWP` and its linked pages.

2. **`textLength`**
   - Computes the number of letters across all text, image names, file types (excluding dots), link labels, and webpage titles.

3. **`images`**
   - Produces a comma-separated list of **all image names with file types** across `fundiesWP` and its linked pages.
   - Example output:
     ```
     "wvh-lab.png, profs.jpeg, htdp.tiff, htdp.tiff"
     ```

