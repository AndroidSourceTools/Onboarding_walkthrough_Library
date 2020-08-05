# OnboardWalkthrough
[![platform](https://img.shields.io/badge/platform-android-green)](https://www.android.com)
[![API](https://img.shields.io/badge/API-19%2B-brightgreen.svg?style=plastic)](https://android-arsenal.com/api?level=19)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![](https://jitpack.io/v/PremMehta022/OnboardWalkthrough.svg)](https://jitpack.io/#PremMehta022/OnboardWalkthrough)



## Screenshots

**Please click the image below to enlarge.**


<a href="https://user-images.githubusercontent.com/49603163/83429448-b12c5400-a451-11ea-8e8c-8ad0188929d0.gif"><img src="https://user-images.githubusercontent.com/49603163/83429448-b12c5400-a451-11ea-8e8c-8ad0188929d0.gif" title="OnboardWalkthrough"/></a>



## Prerequisites

```
allProjects{
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```


## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.PremMehta022:OnboardWalkthrough:1.0.0'
}
```

## How to use?

- #### Add in XML layout file
      <com.shivamkibhu.onboardwalkthrough.OnboardWalkthrough
        android:id="@+id/mainView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
		
- #### Add in Java file
		   getSupportActionBar().hide();
        OnboardWalkthrough view = findViewById(R.id.mainView);

        Page page1 = new Page();
        Page page2 = new Page();
        Page page3 = new Page();
        Page page4 = new Page();


        page1.setBackgroundColor("#E8290B").setTitle("Fresh")
                .setDescription("Find all as fresh")
                .setTitleColor("#ffffff")
                .setDescriptionColor("#ffffff")
                .setTitleSize(23)
                .setDescriptionSize(18);


        page2.setBackgroundColor("#FBD28B")
                .setTitle("Clean")
                .setDescription("Clean is clear");


        page3.setTitle("Green")
                .setDescription("Will green forever")
                .setBackgroundColor("#F5BCBA")
                .setImage(R.drawable.shop2)
                .setImageLayoutParams(500, 100, 300, 300, 300, 0);


        page4.setImage(R.drawable.shop)
                .setImageLayoutParams(100, 100, 0, 500, 0, 0)
                .setBackgroundColor("#00CCCD")
                .setTitle("Move")
                .setDescription("Feel satisfied")
                .setTitleSize(18)
                .setDescriptionSize(15);


        view.setStartTitle("Lets take")
                .setStartClickListener(new PageListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this, "Take clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setSkipClickListener(new PageListener() {
            @Override
            public void OnClick() {
                Toast.makeText(MainActivity.this, "Skip  Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        view.add(page1);
        view.add(page2);
        view.add(page3);
        view.add(page4);

        view.build();


## Props

#### Page props
- setBackgroundColor (String):    Background color for whole current layout 
- setImage (int):    Image(Icon)
- setImageLayoutParams (int width, int height, int leftMargin, int topMargin, int rightMargin, int bottomMargin):    Image params
- setTitle (String):    Title text
- setTitleColor (String):    Title text color
- setTitleSize (int):    Title text size
- setDescription (String):    Description / Message text
- setDescriptionColor (String):    Desxription text color
- setDescriptionSize (String):    Description text size
- setTitleContainerMargin (int marginLeft, int marginTop, int marginRight, int marginBottom):    Title and Description Layout params margins

#### OnboardWalkthrough props
- setSkipBackgroundColor (String):    Skip text background color
- setSkipClickListener (PageListener):    Skip click listener
- setSkipTextSize (int):    Skip text size
- setSkipVisibility (boolean):    [By default- true] Skip visibility
- setSkipColor (String):    Skip text color
- setStartTitle (String):    Bottom Start button title
- setStartVisibility (boolean):    Start visibility
- setStartClickListener (PageListener):    Start button click listener
- setStartTextSize (int):    Start text size
- setStartColor (String):    Start text color
- setProgressColor (String):    Bottom Progress indicator color
- setProgressVisibility (boolean):    [By default- true] Progress indicator visibility
- add (Page):    Add Page to the library
- build:    Build the expected layout(**Mandatory to write**)




## Contributing

Please fork this repository and contribute back using
[pull requests](https://github.com/PremMehta022/OnboardWalkthrough/pulls).

Any contributions (large or small/ major or minor/ new features/ bug fixes) are welcomed and appreciated
but will be thoroughly reviewed.

### Contact - Let's become friend

- [Github](https://github.com/PremMehta022)
- [Linkedin](https://www.linkedin.com/in/premmehta/)


## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2020 Prem Mehta

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
