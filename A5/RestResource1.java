package com.assignment;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("")
public class RestResource1 {

    @Path("hello/{name}")
    @GET
    @Produces("text/plain")
    public String getName(@PathParam("name") String name){
        return "Hello " + name;
    }
}

/*
@GET
    @Path("/add/{a},{b},{opt}")
    public int add(@PathParam("a") int a,@PathParam("b") int b,@PathParam("opt") String opt)
    {
        if(opt.equals("+"))
            return a+b;
        else
              return 0;
    }
    
    @GET
    @Path("/sub/{a},{b},{opt}")
    public int sub(@PathParam("a") int a,@PathParam("b") int b,@PathParam("opt") String opt)
    {
        if(opt.equals("-"))
            return a-b;
        else
              return 0;
    }
    
    @POST
    @Path("/mul")
    public int mul(@FormParam("a") int a,@FormParam("b") int b,@FormParam("opt") String opt)
    {
        if(opt.equals("*"))
            return a*b;
        else
            return 0;
    }
    
    @POST
    @Path("/div")
    public int div(@FormParam("a") int a,@FormParam("b") int b,@FormParam("opt") String opt)
    {
        if(opt.equals("/"))
            return a/b;
        else
            return 0;
    }
    
    
    @POST
    @Path("/calculator_Post")
    public int calculator_Post(@FormParam("a") int a,@FormParam("b") int b,@FormParam("opt") String opt)
    {
        if(opt.equals("#"))
            return a+b;
        else if(opt.equals("-"))
            return a-b;
        else if(opt.equals("*"))
            return a*b;
        else if(opt.equals("/"))
            return a/b;
        else
              return 0;
    }
            
    @GET
    @Path("/calget/{a},{b},{opt}")
    public float calget(@PathParam("a") int a,@PathParam("b") int b,@PathParam("opt") String opt)
    {
        if(opt.equals("+"))
            return a+b;
        else if(opt.equals("-"))
            return a-b;
        else if(opt.equals("*"))
            return a*b;
        else if(opt.equals("!"))
            return (a/b);
        else
              return 0;
    }
    */
