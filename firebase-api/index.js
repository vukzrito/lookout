const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);
const firestore = admin.firestore();



exports.createIncident = functions.https.onRequest((request, response) => {
  if (request.method != "POST") {
    response.status(405).send("Method not allowed");
    return;
  }
  response.code = 201;
  response.send("Email sent");
});

exports.incidents = functions.https.onRequest((request, response) => {

  const incidentsRef = firestore
    .collection("incidents");
   incidentsRef.get(querySnapshot => {
    let events = [];
    querySnapshot.forEach(doc => {
      events.push({
        info:doc.data(),
        id: doc.id
      });
    });
console.log(`Upcoming events  ${JSON.stringify(events)}`);
  }).then((ref) => {
    response.statusCode = 200;
    response.send(`{"success" :${events} }`);
    return events;
  }).catch((err) => {
    response.statusCode = 500;
    response.send(err);
    return err;
  });
});