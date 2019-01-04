# XML

Rules to follow:
 - Element names are case-sensitive
 - Element names must start with a letter or underscore (also can start with colon (:))
 - Element names cannot start with the letters 'xml' (or XML, or Xml, etc)
 - Element names can contain letters, digits, hyphens, underscores, and periods
 - Element names cannot contain spaces
 -  ``<foo><bar></foo></bar>`` is not allowed
 
 ## Syntax
 Each tag has to contain a root node
 ```xml
<root>
  <child>
    <subchild>.....</subchild>
  </child>
</root>
```

 Usage of predefined characters
 ```xml
<message>salary &lt; 1000</message>
```
 Predefined characters (no spaces between & and the rest)
 
 | Sign          | Meaning       |
 | ------------- |:-------------:|
 | & lt;	     | '<'           |
 | & gt;	     | '>'           |
 | & amp;	     | '&'           |
 | & apos;	     | '             |
 | & quot;	     | "             |
 
 
 ## Attributes
 ````xml
<person gender="female">
  <firstname>Anna</firstname>
  <lastname>Smith</lastname>
</person>
````

 #### Standalone attribute

``<xml standalone="yes/no">``

*The standalone declaration is a way of telling the parser to ignore any markup declarations in the DTD. The DTD is thereafter used for validation only.*

*As an example, consider the humble <img> tag. If you look at the XHTML 1.0 DTD, you see a markup declaration telling the parser that <img> tags must be EMPTY and possess src and alt attributes. When a browser is going through an XHTML 1.0 document and finds an <img> tag, it should notice that the DTD requires src and alt attributes and add them if they are not present. It will also self-close the <img> tag since it is supposed to be EMPTY. This is what the XML specification means by "markup declarations can affect the content of the document." You can then use the standalone declaration to tell the parser to ignore these rules.*

 ## Namespaces
 Namespaces are used to differentiate between 2 tags with the same name by adding a namespace before them - ``<namespace:tagname/>``. Before doing so,
 a namespace must be declared either in the beginning of the document (or parent) or in the tag itself. Namespaces are specified with a URI.
 
 ```xml
<h:table xmlns:h="http://www.w3.org/TR/html4/">
  <h:tr>
    <h:td>Apples</h:td>
    <h:td>Bananas</h:td>
  </h:tr>
</h:table>

```

or 

```xml
<root xmlns:h="http://www.w3.org/TR/html4/"
xmlns:f="https://www.w3schools.com/furniture">

<h:table>
  <h:tr>
    <h:td>Apples</h:td>
    <h:td>Bananas</h:td>
  </h:tr>
</h:table>

<f:table>
  <f:name>African Coffee Table</f:name>
  <f:width>80</f:width>
  <f:length>120</f:length>
</f:table>

</root>
```

## XPath
Given an XML code

### Absolute Path
That basically means the examples below start from the 'root'. If we imagine the DOM as a tree, it starts from the very top. 
It is faster than the relative path since it doesn't search

- ``/root/child/another`` selects the node of "another" starting from the root node. It is called absolute path
- ``/root/child[@resistivity]`` selects all the nodes with tag of "child" which have an attribute called "resistivity"
- ``/root/child[1]`` selects the 1st "child" node (counting starts from 1)
- ``/root/child[position()=1]`` does the same thing as the previous one
- ``/root/child[position()!=1]`` selects all the child nodes except for the first one
- ``/root/child[not(position()=1)]`` does the same thing as the previous one
- ``/root/child[last()]`` selects the last child node
- ``parent/child`` selects all the "child" nodes which are direct descendants of "parent" node
- ``/parent/child[text()]`` selects the text content of all the "child" nodes
- ``/*`` selects the root element regardless of the name
- ``./child`` selects all the child elements of the current node. ``./`` indicates the current(or currently being processed) node

### Relative Path
That basically means the examples below doesn't need to start from the root. It can be in any position. Since it requires searching, 
it is slower than Absolute Path

- ``//child[not(@aeroplane)]`` selects all the "child" nodes which doesn't have the "aeroplane" attribute
- ``//child[@podcast='yes']`` selects all the "child" nodes which have the "podcast" attribute with the value "yes"
- ``parent//child`` selects all "child" nodes that are descendant of the "parent" node, no matter where they are under the parent node
- ``//*`` selects all the elements in the document
