import 'package:flutter/material.dart';

class HelloCard extends StatelessWidget {
  const HelloCard({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("HelloCard"),
      ),
      body: Container(
        alignment: Alignment.center,
        child: Stack(
          alignment: Alignment.topCenter,
          children: <Widget>[
            _getCard(),
            _getAvatar()
          ],
        ),
      ),
    );
  }
}

Container _getCard() {
  return Container(
    width:350,
    height: 200,
    margin: EdgeInsets.all(50),
    decoration: BoxDecoration(
      color: Colors.blueAccent,
      borderRadius: BorderRadius.circular(26),

    ),
    child: Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Text("Hello, Students",
          style: TextStyle(fontSize: 24,
              color:Colors.greenAccent),),
        Text("Heppy New Year!!!!"),
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(Icons.two_k_rounded),
            Icon(Icons.ac_unit),
            Icon(Icons.two_k_rounded),
            Icon(Icons.two_k_rounded),
          ],
        )
      ],
    ),
  );
}
Container _getAvatar(){
  return Container(
    width:100,
    height: 100,
    decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.all(Radius.circular(50.0)),
        border: Border.all(color:Colors.orange,width: 1.2),
        image: DecorationImage(image: NetworkImage("https://picsum.photos/300/300"),
            fit:BoxFit.cover)
    ),
  );

}
