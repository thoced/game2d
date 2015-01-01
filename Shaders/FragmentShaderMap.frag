uniform sampler2D maTexture;

void main()
{
 // gl_FragColor = gl_Color - (((gl_FragCoord.x ) / 16.0) * vec4(0.01,0.05,0.05,0.0));
 
    vec4 color = texture2D(maTexture,gl_TexCoord[0].xy).rgba;
    color.a = 1.0;
    color.r = 1.0;
    gl_FragColor =  vec4(0.5,0.5,0.5,1.0);
 
   //gl_FragColor = texture2D(backTexture,gl_TexCoord[0].st).rgba + texture2D(maTexture,gl_TexCoord[0].st).rgba * 0.5 * deltaTime;
 
 }
