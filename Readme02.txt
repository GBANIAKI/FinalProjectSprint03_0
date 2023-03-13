# private-repos-project
This text report on sucessful and failed features and patterns used on my code related on the CSC 450 Final Project at DePaul University. It also exposed the link to my code.
The Ellipse is not dashed outlned perfectly.
I was able to implement more than 5 design patterns in this code so far. 
The committed folder may miss some files, but that doesn't mean that i didn't finsish the homework. It means that something went wrong while exporting from Intelij isea. this 
computer is not working well. I still have a correct copy of the project.

The Link to GitHub repo is https://github.com/GBANIAKI/private-repos-project/new/main?readme=1

I was able to use at least 6 design pattern in this sprint:
    . Null Object pattern: Application-NullApplication/IApplication
                           ShapeListManager-NullShapeListmanager/IShapeListManager
                           Gui-NullGui/IUiModule
                           MasterShapelist-NullMasterShapeList/IDrawSubject
                           SelectedShapeList-NullSelectedShapeList/IDrawSubject
                           ClipBoardShapeList-NullClipBoardShapeList/IDrawSubject
                           ........
     . Strategy Factory: RectangleStrategy, EllipseStrategy, TriangleStrategy/IDrawShapeStrategy
     . Factory pattern: DrawShapeStrategyFactory/IDrawShapeStrategy
      . Factory pattern: ShapeFactory/IShape
      . Observer Pattern: ShapeDrawer/IDrawObserver
      . Provider pattern: Dialog Provider/IDialogProvider 
      Proxy Pattern    : DashedOutLineTriangle/DrawTriangleStrategy
                         DashedOutLineEllipse/ DrawEllipseStrategy
                         DashedOutLineRectangle/DrawRectangleStrategy