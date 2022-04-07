import React, {useMemo} from 'react'
import { useTable, useSortBy, useGlobalFilter, usePagination, useRowSelect } from 'react-table'
import MOCK_DATA from './MOCK_DATA.json'
import { COLUMNS } from './columns'
import './table.css'
import { GlobalFilter } from './GlobalFilter'
import { Checkbox } from './Checkbox'

export const RowSelection = () => {
    const columns=useMemo(()=>COLUMNS,[])
    const data=useMemo(()=>MOCK_DATA,[])

    const tableInstance=useTable({
        columns:columns,
        data: data
    },  useRowSelect,(hooks)=>{
        hooks.visibleColumns.push((columns)=>{
            return [
                {
                    id:'selection',
                    Header:({ getToggleAllRowsSelectedProps })=>(
                        <Checkbox {...getToggleAllRowsSelectedProps()} />
                    ),
                    Cell:({row})=>(
                        <Checkbox {...row.getToggleAllRowsSelectedProps()} />
                    )
                },
                ...columns
            ]
        })

    })

    const {getTableProps, 
        getTableBodyProps, 
        headerGroups, 
        //footerGroups, 
        page, 
        nextPage,
        previousPage,
        canNextPage,
        canPreviousPage,
        pageOptions,
        gotoPage,
        pageCount,
        setPageSize,
        prepareRow,
        selectedFlatRows,
        state,
        setGlobalFilter,

    }=tableInstance


    const {globalFilter, pageIndex, pageSize} =state;


  return (
      <>
      <GlobalFilter filter={globalFilter} setFilter={setGlobalFilter}/>
        <table {...getTableProps()}>
        <thead>
            {
                headerGroups.map((headerGroup)=>(
                <tr {...headerGroup.getHeaderGroupProps()}>
                    {
                        headerGroup.headers.map( column => (
                            <th {...column.getHeaderProps(column.getSortByToggleProps())}>
                                {column.render('Header')}
                                <span>
                                    {column.isSorted? (column.isSortedDesc ? ' 🔽' : ' 🔼') : ''}
                                </span>
                            </th>
                        ))
                    }
                    
                </tr>
                ))
            }
            
        </thead>
        <tbody {...getTableBodyProps()}>
            {
                page.map(row =>{
                    prepareRow(row)
                    return (
                        <tr {...row.getRowProps()}>
                            {
                                row.cells.map( cell =>{
                                  return  <td {...cell.getCellProps()}>{cell.render('Cell')}</td>

                                })
                            }
                            
                        </tr>
                    )
                })
            }
           
        </tbody>
        {/* <tfoot>
            {
                footerGroups.map((footerGroup)=>(
                <tr {...footerGroup.getFooterGroupProps()}>
                    {
                        footerGroup.headers.map( column => (
                            <th {...column.getFooterProps()}>{column.render('Footer')}</th>
                        ))
                    }
                    
                </tr>
                ))
            }
            
        </tfoot> */}
        
    </table>
        <div>
            <span>
                Page{' '}
                <strong>{pageIndex + 1} of {pageOptions.length}</strong>{' '}
            </span>
            <span>
                | Go to page: {' '} 
                <input type="number" 
                onChange={e=>{
                    const pageNumber=e.target.value? Number(e.target.value) -1:0;
                    gotoPage(pageNumber)
                }}
                value={pageIndex+1}
                style={{width:'50px'}}>

                </input>
            </span>
            <select value={pageSize} onChange={e=>{setPageSize(Number(e.target.value))}}>
                {
                    [5,10,25,50].map(pageSize=>(
                        <option key={pageSize} value={pageSize}>Show {pageSize}</option>
                    ))
                }
            </select>
            <button onClick={()=> gotoPage(0)} disabled={!canPreviousPage}>{'<<'}</button>
            <button onClick={()=> previousPage()} disabled={!canPreviousPage}>Previous</button>
            <button onClick={()=> nextPage()} disabled={!canNextPage}>Next</button>
            <button onClick={()=> gotoPage(pageCount-1)} disabled={!canNextPage}>{'>>'}</button>
        </div>
        <pre>
            <code>
                {
                    JSON.stringify({
                        selectedFlatRows:selectedFlatRows.map((row)=>row.original),
                    },
                    null,
                    2)
                }
            </code>
        </pre>
    
    </>
  )
}
