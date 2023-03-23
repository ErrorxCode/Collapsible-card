
# Collapsible card layout
<p align="left">
  <a href="#"><img alt="Languages-Java" src="https://img.shields.io/badge/Language-Java-1DA1F2?style=flat-square&logo=java"></a>
  <a href="#"><img alt="Version" src="https://jitpack.io/v/ErrorxCode/Collapsible-card.svg"></a>
  <a href="https://www.instagram.com/x0.rahil/"><img alt="Instagram - x0.rahil" src="https://img.shields.io/badge/Instagram-x0.rahil-lightgrey"></a>
  <a href="#"><img alt="Downloads" src="https://jitpack.io/v/ErrorxCode/Collapsible-card/month.svg"></a>
  <a href="#"><img alt="GitHub Repo stars" src="https://img.shields.io/github/stars/ErrorxCode/Collapsible-card?style=social"></a>
  </p>

> "The less the space occipied, the more the clean ui looks"

This library provides a simple Collapsible card-like layout in which you can put any number of views that can be collapsed and expended when required.


<img src=https://user-images.githubusercontent.com/65817230/227319350-305054be-3118-4e82-8ca9-c6aa4b7bb1f7.png width=60%>



## Implementation

To deploy this project run

**Step 1**. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
**Step 2**. Add the dependency

	dependencies {
	        implementation 'com.github.ErrorxCode:Collapsible-card:Tag'
	}
[![](https://jitpack.io/v/ErrorxCode/Collapsible-card.svg)](https://jitpack.io/#ErrorxCode/Collapsible-card)


## Usage/Examples

The **CollapsibleCard** extends **RelativeLayout**. So you can place your views directly inside it.

- **add 'main' to tag** of the child view you don't want to hide on collapsing.
```xml
<com.errorxcode.card.CollapsibleCard
    android:id="@+id/card"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp">
    
    ...
    ... 

</com.errorxcode.card.CollapsibleCard>
```
- The card will expand collapse automatically on the clicking of 'main' view.


**Note:** _You should not put any other layout inside it. The animation will fail if you do so_.

**Demo example code**:
```xml
<com.errorxcode.card.CollapsibleCard
    android:id="@+id/card"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp">

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@color/black"
        android:tag="main"
        android:layout_centerHorizontal="true"
        android:textSize="20sp"
        android:layout_margin="10dp"
        android:text="Finderprints"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/textview"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="100dp"
        android:text="Button"/>

</com.errorxcode.card.CollapsibleCard>
```

and through java, you can anytime call `collapse()` or `expand()`.

You can also modify transition using `setCustomTransition()` method like this:
```java
var transition = new AutoTransition();
transition.setDuration(3000);
transition.setInterpolator(new BounceInterpolator());

card.setCustomTransition(transition);
```
## Contributing

Contributions are always welcome!

What you can do is you can add more customization options to it. You can contact me on [instagram](https://instagram.com/x0.rahil) before making a pull request.



