$(document).ready(function () {
  const getAllMessages = () => {
    $.get('http://localhost:8080/garden-chat-api/getallmessages')
      .done((response) => {
        renderMessages(response)
        console.log(response)
      })
      .fail((error) => {
        console.log('failed', error)
      })
  }

  const renderMessages = (messages) => {
    messages.reverse()
    $.each(messages, (index, msg) => {
      const formattedTimestamp =
        msg.timestamp !== null
          ? msg.timestamp.replace('T', ' ').substring(0, 16)
          : ''

      $('#messages').append(
        `<li>
        <img
          id=${index % 2 === 0 ? 'leaf-left' : 'leaf-right'}
          src=${index % 2 === 0 ? 'leaf-left.svg' : 'leaf-right.svg'}
          alt='leaf'
        />
        <p>
          <span id='timestamp'>${formattedTimestamp}</span><br>
          <span id='sender'>${msg.sender + ':'}</span><br>
          <span class='message'>${msg.message}</span>
        </p>
      </li>`
      )
    })
  }

  getAllMessages()

  $('form').submit((event) => {
    event.preventDefault()
    const url = 'http://localhost:8080/garden-chat-api/postmessage'
    const body = JSON.stringify({
      sender: $('#namefield').val(),
      message: $('#messagefield').val()
    })
    console.log(body)
    $.ajax({
      url: url,
      type: 'POST',
      data: body,
      contentType: 'application/json',
      complete: callback
    })
  })
  const callback = (response) => {
    console.log(response.responseText)
    // getAllMessages()
  }
})
